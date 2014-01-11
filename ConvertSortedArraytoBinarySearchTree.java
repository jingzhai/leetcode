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
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        return hbBST(num, 0, num.length-1);
    }
    private TreeNode hbBST(int[] num, int s, int e) {
        if (s==e) return new TreeNode(num[s]);
        if (s>e) return null;
        int m = (s+e)/2;
        TreeNode root = new TreeNode(num[m]);
        root.left = hbBST(num, s, m-1);
        root.right = hbBST(num, m+1, e);
        return root;
    }
}
