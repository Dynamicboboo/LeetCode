//给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。 
//如果可以，请返回 True；否则，返回 False。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,3,4,4,5,6], k = 4
//输出：true
//解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
// 
//
// 示例 2： 
//
// 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//输出：true
//解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
// 
//
// 示例 3： 
//
// 输入：nums = [3,3,2,2,1,1], k = 3
//输出：true
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3,4], k = 3
//输出：false
//解释：数组不能分成几个大小为 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 1 <= k <= nums.length 
// 
// Related Topics 贪心算法 数组 
// 👍 33 👎 0


import com.sun.javafx.collections.MappingChange;

import java.util.Arrays;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        int resNeed = len/k;
        if (len%k != 0){
            return false;
        }
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num , map.getOrDefault(num,0)+1);
        }
        int countRes = 0;
        for (int num : nums){
            int resNum = map.get(num);//num 存在的数量
            if (resNum == 0){
                continue;
            }
            map.put(num,resNum-1);
            for (int i = 1 ;i <k; i++){
                int resNextNum = map.getOrDefault(num+i,0);
                if (resNextNum == 0){
                    return false;
                }
                map.put(num+i,resNextNum-1);
            }
            countRes++;
            if (countRes == resNeed){
                return true;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
