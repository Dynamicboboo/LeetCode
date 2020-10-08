//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 981 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates,0,len,target, path,  res);
        return res;
    }
    public void dfs(int[] candidates,int begin, int len ,int target,Deque<Integer> path,List<List<Integer>> res ){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = begin; i < len ; i++) {
            if (target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
