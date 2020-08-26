//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4789 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 解题思路：
 * 2. Add Two Numbers
 * 题意：两个链表，节点上的数逆序组成一个数字，求和，返回链表
 * 难度：Medium
 * 分类：Linked List, Math
 * 算法：两个链表一起遍历，按位加，注意进位
 * Tips：不要遍历完一个链表保存为变量，求变量和再转化为链表。因为链表可能很长，变量无法保存下来；
 *       注意考虑两个链表长度不一致的问题
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);//设置一个空的头节点 方便curr 记录从第一个相加的数据
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;//不等于空直接获取当前结点值
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;  //计算
            carry = sum / 10;  //carry /10 表示判断是否向高位进1
            curr.next = new ListNode(sum % 10);// sum取余，判断是否大于10，大于则保留余数，不大于则直接赋值
            curr = curr.next;//将指针移到当前结点
            if (p != null) p = p.next;//获取P链表下一个值
            if (q != null) q = q.next;
        }
        if (carry > 0) { //全部计算完判断最高位相加 是否大于10 如果大于10 则向更高一位进1
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
