解题思路：
1，先考虑直接硬解。将两个链表转整数，相加后再将整数转链表。提交发现整数超出范围值会和预期结果不一样。
2，然后考虑整数类型从int提升到long，但是超过long的范围还是不行。
3，题目没给链表长度限制，那就只能换思路，一个一个数处理了。需要考虑进位的问题，引入变量carry存储进位的值。

最终解题代码：
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        while(cur1 != null || cur2 != null){
            int val1 = cur1 != null ? cur1.val : 0;
            int val2 = cur2 != null ? cur2.val : 0;
            cur.next = new ListNode((val1+val2+carry) % 10);
            cur = cur.next;
            carry = (val1+val2+carry) / 10;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }
        if(carry > 0) cur.next = new ListNode(carry);
        return head.next;
    }
}
```

解题过程错误思路代码：
```
class Solution {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        long numA = nodeSwitchNum(L1);
        long numB = nodeSwitchNum(L2);
        long sum = numA + numB;
        return numSwitchNode(sum);
    }

    /* 链表转整数 */
    private long nodeSwitchNum(ListNode head) {
        long num = 0L;
        long multiple = 1L;
        ListNode cur = head;
        while (cur != null) {
            num += cur.val * multiple;
            cur = cur.next;
            multiple *= 10;
        }
        return num;
    }

    /* 整数转链表 */
    private ListNode numSwitchNode(long num) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        do {
            cur.next = new ListNode((int) (num % 10L));
            num = num / 10;
            cur = cur.next;
        } while (num != 0);
        return head.next;
    }
}
```

