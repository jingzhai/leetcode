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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> nlist = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nsublist = new ArrayList<TreeNode>();
        if (root==null) return llist; 
        nlist.add(root);
        while(!nlist.isEmpty()) {
            ArrayList<TreeNode> currlist = new ArrayList<TreeNode>();
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            for (TreeNode node : nlist) {
                ilist.add(node.val);
                if (node.left!=null) {
                    currlist.add(node.left);
                }
                if (node.right!=null) {
                    currlist.add(node.right);
                }
            } 
            llist.add(ilist);
            nlist=currlist;
        }
        return llist; 
    }
}
