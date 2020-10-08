//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 608 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1,-1};
        int leftIdx = searchLeft(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = searchLeft(nums, target, false)-1;

        return targetRange;

    }
    public int searchLeft(int[] nums, int target ,  boolean left){
        int l = 0 , r = nums.length;
        while(l < r){
            int mid = (r+l)/2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
