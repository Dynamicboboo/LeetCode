//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 418 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(candidates , res , path , target ,0 ,0  );
        return res;
    }

    private static void dfs(int[] candidates, List<List<Integer>> res, Deque<Integer> path, int target,int sum, int begain) {
        // TODO Auto-generated method stub
        if(sum>=target) {
            if(sum==target) {
                List<Integer> ls = new ArrayList<Integer>(path);
                if(!res.contains(ls)) {
                    res.add(ls);
                }
            }
            return;
        }
        for(int i=begain;i<candidates.length;i++) {

            path.add(candidates[i]);
            sum+=candidates[i];
            dfs(candidates, res, path, target, sum,i+1);
            path.removeLast();
            sum-=candidates[i];
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
