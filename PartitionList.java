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
    public ListNode partition(ListNode head, int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null || head.next==null) return head;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next=head;
        ListNode node = newHead;
        ListNode pnode = null;
        ListNode insertAfter = null;
        ListNode prev = null;
        while(node!=null) {
            if (pnode==null) {
                if (node.val<x) {
                    insertAfter = node;
                    prev = node;
                    node=node.next;
                } else if (node.val>=x) {
                    pnode=node;
                    prev=node;
                    node=node.next;
                }
            } else {
                if (node.val<x) {
                    prev.next=node.next;
                    insertAfter.next=node;
                    node.next=pnode;
                    insertAfter=node;
                    node=prev.next;
                } else {
                    prev=node;
                    node=node.next;
                }
            }
        }
        return newHead.next;
    }
}
