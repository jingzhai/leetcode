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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int maxvalue = maxToNode(root);
        return (max>maxvalue)?max:maxvalue;
    }
    private int maxToNode(TreeNode root) {
        if (root==null) return 0;
        int maxvalue=root.val;
        int leftmax = maxToNode(root.left);
        int rightmax = maxToNode(root.right);
        if (leftmax>0) maxvalue+=leftmax;
        if (rightmax>0) maxvalue+=rightmax;
        if (max<maxvalue) max=maxvalue;
        return Math.max(leftmax,rightmax)>0?Math.max(leftmax,rightmax)+root.val:root.val;
    }
}
