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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        //if (head==null) return head;
        ListNode fnode = head;
        ListNode bnode = head;
        
        for (int i=0;i<n;i++) {
            fnode=fnode.next;
        }
        if (fnode==null) {
            return head.next;
        }
        while (fnode.next!=null) {
            fnode=fnode.next;
            bnode=bnode.next;
        }
        bnode.next=bnode.next.next;
        return head;
    }
}
