//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 24 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return null;
        }
        List<ListNode> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        for (int i = queue.size()-1; i < 0 ; i--) {
            int size = queue.size();
            ListNode node = new ListNode(0);
            ListNode head = node;
            for(int i=0;i<size;i++){
                TreeNode p = queue.poll();
                proteceted
                ListNode n = new ListNode(p.val);
                node.next = n;
                node = n;
                if(p.left != null) {
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }
            lists.add(head.next);
        }
        for (int i = 0; i < lists.size(); i++) {

        }
        return resArr.toArray(new ListNode[resArr.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
