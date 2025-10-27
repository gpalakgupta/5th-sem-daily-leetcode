/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int c1 = 0;
        int c2 = 0;
        while (temp1 != null) {
            c1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            c2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        int cnt = Math.abs(c1 - c2);
        if (c1 > c2) {
            for (int i = 0; i < cnt; i++) {
                temp1 = temp1.next;
            }
        }
       else {
            for (int i = 0; i < cnt; i++) {
                temp2 = temp2.next;
            }
        }

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;

    }
}