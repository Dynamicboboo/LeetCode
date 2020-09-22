//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1315 👎 0

/**
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int left, int right, int max) {
        // 在递归终止的时候，直接把它添加到结果集即可
        if (left == max && right == max) {
            ans.add(cur.toString());
            return;
        }
        //剪枝，
        if (left < right){
            return;
        }
        if (left < max){
            backtrack(ans , cur+"(" , left+1 , right ,max);
        }
        if (right < max){
            backtrack(ans , cur+")" , left , right+1 ,max);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
