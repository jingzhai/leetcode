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
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (depth(root)==-1) return false;
        return true;
        
    }
    private int depth(TreeNode node) {
        int dep = 0;
        if (node!=null){ 
            int ldepth = depth(node.left);
            int rdepth = depth(node.right);
            if (ldepth==-1 || rdepth==-1) return -1;
            dep = Math.max(depth(node.left),depth(node.right))+1;
            if (Math.abs(ldepth-rdepth)>1) {
                return -1;
            }
        }
        return dep;
    }

}
