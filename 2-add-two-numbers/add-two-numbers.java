/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode t = new ListNode(0);
        ListNode dummy = t;
        int carry = 0;
        while (t1 != null || t2 != null) {
            int a = (t1 != null) ? t1.val : 0;
            int b = (t2 != null) ? t2.val : 0;
            int sum = a + b + carry;
            t.next = new ListNode(sum % 10);
            t = t.next;
            carry = sum / 10;
            if (t1 != null)
                t1 = t1.next;
            if (t2 != null)
                t2 = t2.next;
        }
        if (carry > 0) {
            t.next = new ListNode(carry);
            t = t.next;
        }
        return dummy.next;

    }
}