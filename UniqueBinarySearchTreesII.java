/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        return genTree(1,n);
    }
    public ArrayList<TreeNode> genTree(int s, int e) {

           
        ArrayList<TreeNode> newlist = new ArrayList<TreeNode>();
        if (s>e) {
            newlist.add(null);
        } 
        for (int i=s;i<=e;i++) {
            ArrayList<TreeNode> leftlist = genTree(s,i-1);
            ArrayList<TreeNode> rightlist = genTree(i+1,e);

            for (TreeNode ltn : leftlist) {
                for (TreeNode rtn : rightlist) {
                    TreeNode node = new TreeNode(i);
                    node.left=ltn;
                    node.right=rtn;
                    newlist.add(node);
                }
            }
        }
        return newlist;
    }
}
