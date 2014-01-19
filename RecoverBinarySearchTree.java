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
    public void recoverTree(TreeNode node) {
        TreeNode f1=null, f2 = null;
        boolean found=false;
        TreeNode pre, parent = null; // previous AND parent
        while (node!=null) { // Morris Traversal
            if (node.left==null) {
                if (parent!=null && parent.val>node.val) { // inorder previous is: parent
                    if (!found) {
                        f1=parent;
                        found=true;
                    }
                    f2=node;
                }
                parent=node;
                node=node.right;
                continue;
            }
            pre=node.left;
            while (pre.right!=null && pre.right!=node) { 
                pre=pre.right;
            }
            if (pre.right==null) {
                pre.right=node;
                node=node.left;
            } else {
                pre.right=null;
                if (pre.val>node.val) { // inorder previous is: pre
                    if (!found) {
                        f1=pre;
                        found=true;
                    }
                    f2=node;
                }
                parent=node;
                node=node.right;
            }
        }
        if (found) {
            int temp=f1.val;
            f1.val=f2.val;
            f2.val=temp;
        }
    }
}
