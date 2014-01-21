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
    public void reorderList(ListNode head) {
        if (head==null) return;
        int len=0;
        ListNode node=head;
        while (node!=null) {
            len++;
            node=node.next;
        }
        int m=len/2; //middle
        node=head;
        for (int i=0;i<m;i++) {
            node=node.next;
        }
        ListNode temp=node.next;
        node.next=null;
        ListNode n2=reverseList(temp);
        ListNode n1=head;
        node=n1;
        n1=n1.next;
        while (n1!=null || n2!=null) {
            if (n2!=null) {
                node.next=n2;
                node=node.next;
                n2=n2.next;
            }
            if (n1!=null) {
                node.next=n1;
                node=node.next;
                n1=n1.next;
            }
        }
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode node=head;
        ListNode next=null;
        while (node!=null) {
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}
