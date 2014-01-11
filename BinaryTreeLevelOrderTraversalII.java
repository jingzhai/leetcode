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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        ArrayDeque<ArrayList<TreeNode>> stack = new ArrayDeque<ArrayList<TreeNode>>();
        if (root==null) return llist; 
        
        ArrayList<TreeNode> nlist = new ArrayList<TreeNode>();
        nlist.add(root);
        stack.push(nlist);
        while(stack.peek().size()>0) {
            ArrayList<TreeNode> currlist = new ArrayList<TreeNode>();
            ArrayList<TreeNode> prevlist = stack.peek();
            for (TreeNode node : prevlist) {
                if (node.left!=null) {
                    currlist.add(node.left);
                }
                if (node.right!=null) {
                    currlist.add(node.right);
                }
            } 
            stack.push(currlist);
        }
        stack.pop();
        while(stack.peek()!=null) {
            ArrayList<TreeNode> tnList = stack.pop();
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            for (TreeNode tn : tnList) {
                ilist.add(tn.val);
            }
            llist.add(ilist);
        }
        return llist; 
        
    }
}
