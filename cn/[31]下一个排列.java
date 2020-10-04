//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 678 👎 0

/**
 * 题意：（求下一个比这个数大的数，可能比给的数大的有很多，但只需要求下一个更大的）
 * 例如 1，2，4，7，6，5，3，1  比其大的有 12713456  、7654311，7116543 等等 但12713456 是最接近它且比他大的
 *
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){ //找到倒数第一个突然变小的数  如1，2，4，7，6，5，3，1 中的4
            i--;
        }
        if (i>=0){
            int j = nums.length-1;
            while (j>=0&&nums[j]<=nums[i]){ //找到刚好 比4大一点的数，5
                j--;
            }
            swap(nums,i,j);//交换4 5
        }
        reverse(nums ,i+1);//将后面从小到大重新排序 保证刚好比原数大且接近的数

    }

    void reverse(int[] nums, int start) {
        int i = start,j = nums.length-1;
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    void swap (int[] nums ,int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}
//leetcode submit region end(Prohibit modification and deletion)
