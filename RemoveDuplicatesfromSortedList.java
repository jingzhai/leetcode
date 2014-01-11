/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        ListNode node = head;
        ListNode prev = null;
        while(node!=null) {
            if (map.get(node.val)!=null) {
                prev.next=node.next;
            } else {
                prev = node;
                map.put(node.val,true);
            }
            node = node.next;
        }
        return head;
    }
}
