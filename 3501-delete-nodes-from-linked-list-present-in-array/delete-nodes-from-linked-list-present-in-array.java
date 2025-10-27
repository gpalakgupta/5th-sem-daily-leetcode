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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();
        for(int el : nums){
            st.add(el);
        }
        return helper(head,st);
    }
    public ListNode helper(ListNode head, HashSet<Integer> st){
        if(head == null){
            return null;
        }
        head.next = helper(head.next,st);
        if(st.contains(head.val)){
            head = head = head.next;
        }
        return head;
    }
}