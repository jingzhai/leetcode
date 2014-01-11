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
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null || head.next==null) return false;
        ListNode snode = head;
        ListNode fnode = head.next.next;
        while (snode!=null && fnode!=null && fnode.next!=null) {
            if (snode.val==fnode.val) return true;
            snode=snode.next;
            fnode=fnode.next.next;
            
        }
        return false;
    }
}
