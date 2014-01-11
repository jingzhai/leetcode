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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        if (node==null) return list;
        stack.push(node);
        
        while (stack.peek()!=null) {
            node=stack.pop();
            list.add(node.val);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }

        }
        return list;
    }
}
