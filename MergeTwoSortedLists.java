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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode newlist = null;
        ListNode n1 = null;
        ListNode n2 = null;
        if(l1.val<l2.val){
            newlist=l1;
            n1=l1.next;
            n2=l2;
        } else {
            newlist=l2;
            n1=l1;
            n2=l2.next;
        }
        merge(newlist,n1,n2);
        return newlist;
    }
    private void merge(ListNode curr, ListNode next1, ListNode next2) {

        if (next1==null) {
            curr.next=next2;
            return;
        }
        else if (next2==null) {
            curr.next=next1;
            return;
        }
        else if (next1.val<next2.val) {
            curr.next=next1;
            curr = next1;
            next1 = next1.next;
        } else {
            curr.next=next2;
            curr = next2;
            next2 = next2.next;
        }
        merge(curr, next1, next2);
    }
}
