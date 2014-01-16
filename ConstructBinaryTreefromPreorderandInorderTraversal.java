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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         if (inorder.length==0) return null;
        
        return construct(inorder,preorder,0,inorder.length-1, 0, preorder.length-1);
    }
    private TreeNode construct(int[] inorder, int[] preorder, int il, int ir, int pl, int pr) {

        TreeNode node = new TreeNode(preorder[pl]);
        if (il==ir) return node;
        int i=0;
        for (;i<inorder.length;i++) {
            if (inorder[i]==preorder[pl]) {
                if (il<i) {
                    node.left = construct(inorder,preorder,il,i-1,pl+1,pl+i-il);
                }
                if (i<ir) {
                    node.right = construct(inorder,preorder,i+1,ir,pr-ir+i+1,pr);
                } 
                break;
            }
        }
        return node;
    }
}
