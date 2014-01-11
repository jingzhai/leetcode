/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null) return null;
        ListNode snode = head;
        ListNode fnode = head;
        while (fnode!=null && fnode.next!=null) {
            snode=snode.next;
            fnode=fnode.next.next;
            if (snode==fnode) break;
        }
        if (fnode==null || fnode.next==null) {
            return null;
        }
        snode = head;
        while (fnode!=snode) {
            fnode=fnode.next;
            snode=snode.next;
        }
        return fnode;
    }
}
