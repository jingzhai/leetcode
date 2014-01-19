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
public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if(lists == null || lists.size() == 0){
        return null;
    }
    ListNode head = new ListNode(0);
    ListNode tmpNode;
    tmpNode = head;

    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
        public int compare(ListNode n1, ListNode n2){
            return n1.val - n2.val;
        }
    });

    for(ListNode node : lists){
        if(node != null){
            heap.add(node);
        }
    }

    while(!heap.isEmpty()){
        ListNode node = heap.poll();
        tmpNode.next = node;
        tmpNode = tmpNode.next;
        if(node.next != null){
            heap.add(node.next);
        }           
    }

    return head.next;       
}
}
