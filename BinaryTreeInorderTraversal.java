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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<TreeNode,Boolean> processed = new HashMap<TreeNode,Boolean>();
        if (node==null) return list;

        stack.push(root);
        
        while (stack.peek()!=null) {
            node=stack.peek();
                        
            while (processed.get(node)==null && node.left!=null) {
                TreeNode toMark = node;
                node=node.left;
                stack.push(node);
                processed.put(toMark,true);
            }
            
            node = stack.pop();
            list.add(node.val);
            if (node.right!=null) {
                stack.push(node.right);
            }
        }
        return list;
    }
}
