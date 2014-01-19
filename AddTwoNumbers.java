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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode node=head;
        boolean carry=false;
        while (l1!=null || l2!=null) {
            int sum=0;
            if (l1!=null) {
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null) {
                sum+=l2.val;
                l2=l2.next;
            }
            if (carry) sum++;
            if (sum>=10) {
                sum=sum-10;
                carry=true;
            } else {
                carry=false;
            }
            node.next=new ListNode(sum);
            node=node.next;
        }
        if (carry) {
            node.next=new ListNode(1);
        }
        return head.next;
    }
}
