public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode node = head;
        int len=0;
        while (node!=null) {
            len++;
            node=node.next;
        }
        return sort(head,len);
    }
    private ListNode sort(ListNode node, int len) {
        if (node==null || len<=0) return null;
        if (len==1) {
            return node;
        }
        ListNode head=new ListNode(0);
        int m=len/2;
        ListNode lnode=node;
        for (int i=0;i<m-1;i++) {
            node=node.next;
        }
        ListNode rnode=node.next;
        node.next=null;
        ListNode node1=sort(lnode,m);
        ListNode node2=sort(rnode,len-m);
        node=head;
        while (node1!=null && node2!=null) {
            if (node1.val<node2.val) {
                node.next=node1;
                node1=node1.next;
            } else {
                node.next=node2;
                node2=node2.next;
            }
            node=node.next;
        }
        if (node1!=null) node.next=node1;
        else node.next=node2;
        return head.next;
    }
}
