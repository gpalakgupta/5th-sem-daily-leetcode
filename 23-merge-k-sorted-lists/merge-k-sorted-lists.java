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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });

ListNode dummy = new ListNode(0);

ListNode t = dummy;
for(int i = 0; i<lists.length; i++){
if(lists[i] != null){
pq.add(lists[i]);
}
}

while(!pq.isEmpty()){
ListNode temp = pq.poll();
t.next = new ListNode(temp.val);
t = t.next;
temp = temp.next;
if(temp != null){
pq.add(temp);
}
}
return dummy.next;
    }
}