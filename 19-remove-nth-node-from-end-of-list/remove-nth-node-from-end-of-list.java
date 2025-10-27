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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int c = 0;
        while (temp != null) {
            temp = temp.next;
            c++;
        }

        temp = head;
        int pos = c - n;
        if(pos == 0){
            return head.next;
        }
        int cnt = 0;
        while (cnt < pos-1) {
            temp = temp.next;
            cnt++;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}