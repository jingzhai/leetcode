public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node end;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<Integer, Node>();
        head=new Node(-1, -1);
        end=new Node(-2, -2);
        head.next=end;
        end.prev=head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFirst(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        Node node=null;
        if (!map.containsKey(key)) {
            if (map.size()==capacity) {
                map.remove(end.prev.key);
                end.prev=end.prev.prev;
                end.prev.next=end;
            }
            node=new Node(key,value);
            node.next=head.next;
            head.next=node;
            node.prev=head;
            node.next.prev=node;
        } else {
            node=map.get(key);
            node.value=value;
            moveToFirst(node);
        }
        map.put(key,node);
    }
    private void moveToFirst(Node node) {
        if (node!=head.next) {
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.next=head.next;
            head.next=node;
            node.prev=head;
            node.next.prev=node;
        }
    }
}
class Node {
    public Node next=null;
    public Node prev=null;
    public int key;
    public int value;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
