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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> plist = new ArrayList<ArrayList<Integer>>();
        
        if (root==null) return plist;

        if (root.left!=null) {
            ArrayList<ArrayList<Integer>> llist = pathSum(root.left, sum-root.val);
            for (ArrayList<Integer> list : llist) {
                list.add(0, root.val);
                plist.add(list);
            }
        } 
        if (root.right!=null) {
            ArrayList<ArrayList<Integer>> rlist = pathSum(root.right, sum-root.val);
            for (ArrayList<Integer> list : rlist) {
                list.add(0, root.val);
                plist.add(list);
            }
        } 
        if (root.left==null && root.right==null) {
            if (root.val==sum) {
                ArrayList<Integer> newlist = new ArrayList<Integer>();
                newlist.add(root.val);
                plist.add(newlist);
            }
        }
        return plist;
    }
}
