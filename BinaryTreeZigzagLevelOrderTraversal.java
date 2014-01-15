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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> llist = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<TreeNode>> lnlist = new ArrayList<ArrayList<TreeNode>>();
        if (root==null) return llist;
        ArrayList<TreeNode> nlist = new ArrayList<TreeNode>();
        nlist.add(root);
        lnlist.add(nlist);
        boolean left2right = true;
        while (nlist.size()>0) {
            ArrayList<TreeNode> currList = new ArrayList<TreeNode>();
            for (TreeNode node : nlist) {
                if (left2right) {
                    if (node.left!=null) currList.add(0, node.left);
                    if (node.right!=null) currList.add(0, node.right);
                } else {
                    if (node.right!=null) currList.add(0, node.right);
                    if (node.left!=null) currList.add(0, node.left);
                }
            }
            if (currList.size()>0) lnlist.add(currList);
            left2right=!left2right;
            nlist = currList;
        }
        for (ArrayList<TreeNode> tnList : lnlist) {
            ArrayList<Integer> ilist = new ArrayList<Integer>();
            for (TreeNode tn : tnList) {
                ilist.add(tn.val);
            }
            llist.add(ilist);
        }
        return llist;
    }
}
