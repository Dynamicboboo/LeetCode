//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2578 👎 0
/**
 * 解题思路：
 * 将数组从小到大排序，i+j+k  如果<0 则j+1 （原因升序），如果>0 则k-1
 * 其中要注意 是否重复
 *
 */

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null){
            return null;
        }
        //如果数组长度小于3，返回一个空集合
        if(nums.length < 3){
            return new ArrayList<>();
        }
        //对数组nums进行排序
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[0]>0) break;
           int j = i+1 , k = nums.length-1;
           while (j<k){
               if (nums[i]+nums[j]+nums[k] == 0){
                   ArrayList<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   set.add(list);
                   //当有重复的数字出现时，j往前跑，防止结果有重复
                   while(j<k && nums[j]==nums[j+1]){//
                       j++;
                   }
                   while(j<k && nums[k]==nums[k-1]){
                       k--;
                   }
                   j++;
                   k--;
               }else if (nums[i]+nums[j]+nums[k] < 0){//升序原因
                   j++;
               }else{
                   k--;
               }
           }
        }
        return  new ArrayList<>(set);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
