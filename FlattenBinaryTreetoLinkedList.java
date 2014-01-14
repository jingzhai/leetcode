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
    public void flatten(TreeNode root) {
        
        if (root==null) return;
        flatten(root.right);
        TreeNode rightLast=root.right;

        if (root.left!=null) {
            flatten(root.left);
            TreeNode leftLast=root.left;
            while(leftLast.right!=null) leftLast=leftLast.right;
            leftLast.right=root.right;
            root.right=root.left;
            root.left=null;
        } 
    }
}
