/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        RandomListNode node = head;
        RandomListNode newhead = new RandomListNode(0);
        RandomListNode nnode=newhead;
        RandomListNode newnode = null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        while (node!=null) {
            newnode = new RandomListNode(node.label);
            nnode.next=newnode;
            map.put(newnode,node);
            map.put(node,newnode);
            nnode=nnode.next; 
            node=node.next;
        }
        node=head;
        newnode=newhead.next;
        while(newnode!=null) {
            if (map.get(newnode).random==null)  {
                newnode.random=null;
            } else {
                newnode.random=map.get(map.get(newnode).random);
            }
            newnode=newnode.next;
        }
        return newhead.next;
    }
    
}
