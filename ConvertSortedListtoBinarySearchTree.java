/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head==null) return null;
        ArrayList<Integer> valList = new ArrayList<Integer>();
        ListNode node=head;
        while(node!=null) {
            valList.add(node.val);
            node=node.next;
        }
        return constructTree(valList,0,valList.size()-1);
    }
    private TreeNode constructTree(ArrayList<Integer> valList, int s, int e) {
        if (s>e) return null;
        int m=(s+e)/2;
        TreeNode parent = new TreeNode(valList.get(m));
        if (s<m) {
            TreeNode left = constructTree(valList,s,m-1);
            parent.left=left;
        }
        if (e>m) {
            TreeNode right = constructTree(valList,m+1,e);
            parent.right=right;
        }
        return parent;
    }
}
