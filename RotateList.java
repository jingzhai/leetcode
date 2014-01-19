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
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null) return head;
        ListNode node = head;
        ListNode last = null;
        int len=0;
        while (node!=null) {
            len++;
            node=node.next;
        }
        n=n%len;
        if (n==0) return head;
        node=head;
        for (int i=0;i<n;i++) {
            node = node.next;
        }
        last=head;
        while (node.next!=null) {
            last=last.next;
            node=node.next;
        }
        node.next=head;
        head=last.next;
        last.next=null;
        return head;
    }
}
