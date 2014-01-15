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
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null || head.next==null) return head;
        ListNode current=head.next;
        ListNode prev=head;
        ListNode next=null;
        
        while (current!=null) {
            if (prev!=null && current.val>=prev.val) {
                prev=current;
                current=current.next;
            } else {
                ListNode node = head;
                ListNode nodeprev = null;
                while (node!=null && current.val> node.val) {
                    nodeprev = node;
                    node=node.next;
                }
                next = current.next;
                current.next=node;
                prev.next=next;
                if (node==head) {   
                    head=current;
                } else {
                    nodeprev.next=current;
                }
                current=next;
            }
            
        }
        return head;
    }
}
