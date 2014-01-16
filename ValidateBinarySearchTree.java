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
    public boolean isValidBST(TreeNode root) {
        return checkValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean checkValid(TreeNode node, int min, int max) {
        if (node==null) return true;
        if (node.val<=min || node.val>=max) return false;
        boolean valid = true;
        if (node.left!=null) {
            valid = valid && checkValid(node.left, min, Math.min(max,node.val));
        }
        if (node.right!=null) {
            valid = valid && checkValid(node.right,Math.max(min, node.val), max);
        }
        return valid;
    }
}
