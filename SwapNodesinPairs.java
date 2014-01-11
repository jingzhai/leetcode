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
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode prev=null;
        ListNode next=null;
        ListNode newHead = null;
        if (head==null || (head!=null && head.next==null)) return head;
        if (head.next!=null) newHead=head.next;
        ListNode node1 = head;
        ListNode node2 = head.next;
        
        while (node1!=null && node2!=null) {
            next=node2.next;
            if (prev!=null) {
                prev.next=node2;
            }
            node1.next=node2.next;
            node2.next=node1;
            prev=node1;
            node1=prev.next;
            if (node1!=null) {
                node2=node1.next;
            } else {
                node2=null;
            }
        }
        return newHead;
    }
}
