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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
        ListNode newhead=new ListNode(Integer.MAX_VALUE);
        newhead.next=head;
        ListNode prev=newhead;
        
        while (node!=null) {
            boolean dup=false;
            while (node.next!=null && node.val==node.next.val) {
                dup=true;
                node=node.next;
            }
            if (dup) {
                prev.next=node.next;
            } else {
                prev.next=node;
                prev=node;
            }
            node=node.next;
        }
        
        return newhead.next;
    }
}
