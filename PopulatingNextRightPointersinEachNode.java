/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root==null) return;
        root.next=null;
        conn(root, root.left, root.right);
    }
    private void conn(TreeLinkNode p, TreeLinkNode l, TreeLinkNode r) {
        if (l==null || r==null) return;
        l.next = r;
        if (p.next!=null) {
            r.next = p.next.left;
        } else {
            r.next = null;
        }
        conn(l,l.left,l.right);
        conn(r,r.left,r.right);
    }
}
