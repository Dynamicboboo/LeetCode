//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1827 👎 0

/**
 * 方法一：暴力解法 ---- 两层循环
 * int maxArea = 0;
 *         for (int i = 0; i < height.length; i++) {
 *             for (int j = i+1; j < height.length; j++) {
 *                 maxArea = Math.max(maxArea , Math.min(height[i],height[j])*(j-i));
 *             }
 *         }
 *         return maxArea;
 *
 *
 *  方法二：双指针法
 *  分别将指针置于左右两端，通过推断：
 *  将 短边 向内移动一个位置时 下个面积可能会变大（高可能增加 宽-1，高达到一定程度则面积增大）
 *  将 长边 向内移动一个位置时 下个面积一盯减小（高不变  宽-1）
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
       int i = 0 ,j = height.length-1 , maxArea = 0;
       while (i < j){
           maxArea = height[i]<height[j] ?
                   Math.max(maxArea , (j - i)*height[i++])://先计算底宽 在乘算面积  最后再右移
                   Math.max(maxArea , (j - i)*height[j--]);
       }
       return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
