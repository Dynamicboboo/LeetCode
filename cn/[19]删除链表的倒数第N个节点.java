//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 956 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 思路： 先将第一个指针L1 移动n个位置，之后 第一个 和第二个在共同移动 直到L1移动到最后一个元素
 * 此时L2 位于即将删除元素的前一位（因为L1和L2是从head的前一位开始移动的）
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0); //预先指针 ，预先指针的next是head
        pre.next = head;
        if (head == null){
            return null;
        }
        ListNode l1 = pre;
        while(l1 != null && n-->0){
            l1 = l1.next;
        }
        ListNode l2 = pre;
        while(l1.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
