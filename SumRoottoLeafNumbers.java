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
    public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return sumTree(root, 0);
    }
    private int sumTree(TreeNode node, int upvalue) {
        if (node==null) return 0;
        upvalue=upvalue*10+node.val;
        if (node.left==null && node.right==null) {
            return upvalue;
        }
        return sumTree(node.left, upvalue)+sumTree(node.right, upvalue);
        
    }
}
