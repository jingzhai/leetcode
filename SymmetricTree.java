/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root==null) return true;
        return (symm(root.left, root.right));
    }
    private boolean symm(TreeNode l, TreeNode r) {
        if (l==null && r==null) return true;
        if ((l!=null && r==null) || (l==null && r!=null)) return false;
        if (l.val==r.val) return symm(l.left,r.right)&&symm(l.right,r.left);
        return false;
    }
}
