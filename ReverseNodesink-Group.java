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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1) return head;
        int len=0;
        ListNode node=head;
        while (node!=null) {
            len++;
            node=node.next;
        }
        ListNode newhead = new ListNode(0);
        newhead.next=head;
        node=head;
        ListNode beforeFirst=newhead;
        for (int i=0;i<len/k;i++) {
            ListNode prev=node;
            node=node.next;
            ListNode next=null;
            for (int j=1;j<k;j++) {
                next=node.next;
                node.next=prev;
                prev=node;
                node=next;
            }
            beforeFirst.next.next=next;
            beforeFirst.next=prev;
            for (int j=0;j<k;j++) {
                beforeFirst=beforeFirst.next;
            }
        }
        return newhead.next;
    }
}
