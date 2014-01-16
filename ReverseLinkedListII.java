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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head;
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        m++;
        n++;
        ListNode node = newhead;
        ListNode nodeB4Rev=null;
        ListNode prev=null;
        ListNode next=null;
        
        for (int i=1;i<m;i++) {
            nodeB4Rev=node;
            node=node.next;
        }
        next=node.next;
        prev=null;
        for (int i=m;i<n;i++) {
            ListNode temp=next.next;
            next.next=node;
            prev=node;
            node=next;
            next=temp;
        }
        nodeB4Rev.next.next=next;
        nodeB4Rev.next=node;
        return newhead.next;
    }
}
