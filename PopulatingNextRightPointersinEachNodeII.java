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
        if (l==null && r==null) return;
        if (l==null && r!=null) {
            r.next=firstChild(p.next);
            conn(r,r.left,r.right);
        } else if (l!=null && r==null) {
            l.next=firstChild(p.next);
            conn(l,l.left,l.right);
        } else {
            l.next = r;
            r.next = firstChild(p.next);
            conn(r,r.left,r.right);
            conn(l,l.left,l.right);
        }
    }
    private TreeLinkNode firstChild(TreeLinkNode p) {
        if (p==null) return null;
        if (p.left!=null) return p.left;
        if (p.right!=null) return p.right;
        return firstChild(p.next);
    }
}
