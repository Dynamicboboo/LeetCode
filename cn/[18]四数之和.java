//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 567 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> res = new ArrayList<>();
       if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;//过滤重复值
            }
            if (nums[i]*4 > target){ //太大了
                break;
            }
            if (nums[i] + 3 * nums[nums.length-1] < target){
                continue;//太小了
            }
            for (int j = i+1; j <nums.length - 2 ; j++) {
                if (j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                if (nums[j] * 3>target-nums[i]) break;//太大了
                if (target-nums[i]-nums[j]>2*nums[nums.length-1]){//太小了 如-11 -10  tar=0       10
                    continue;
                }
                int start = j+1 ,end = nums.length-1;
                while (start<end){
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        while (start<end && nums[start] == nums[start+1]){
                            start++;
                        }
                        while (start<end && nums[end] == nums[end-1]){
                            end--;
                        }
                        end--;
                        start++;
                    }
                    else if (sum < target){
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
