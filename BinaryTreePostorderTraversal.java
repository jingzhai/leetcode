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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root==null) return list;
        stack.push(root);
        TreeNode curr=null;
        TreeNode prev=null;
        while(stack.peek()!=null) {
            curr = stack.peek();
            if ((curr.left==null && curr.right==null) || (prev!=null && (prev==curr.left || prev==curr.right))) {
                prev=stack.pop();
                list.add(curr.val);
            }
            else {
                if (curr.right!=null) stack.push(curr.right);
                if (curr.left!=null) stack.push(curr.left);
            }
        }
        return list;
    }
}
