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
    public int minDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        if (root.left!=null && root.right==null) return minDepth(root.left)+1;
        if (root.left==null && root.right!=null) return minDepth(root.right)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
