/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        UndirectedGraphNode newnode=new UndirectedGraphNode(node.label);
        map.put(node,newnode);
        for (UndirectedGraphNode nbr: node.neighbors) {
            UndirectedGraphNode newnbr = null;
            if (map.containsKey(nbr)) {
                newnbr = map.get(nbr);
            } else {
                newnbr = cloneGraph(nbr);
            }
            newnode.neighbors.add(newnbr);
        }
        return newnode;
    }
}
