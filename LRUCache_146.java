import java.util.HashMap;
import java.util.Map;

class LRUCache_146 {

    class LinkedNode {
        int key;
        int value;
        public LinkedNode next;
        public LinkedNode pre;

        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        LinkedNode() {
        }
    }

    private Map<Integer, LinkedNode> map;
    private int size, capacity;
    private LinkedNode head, tail;

    private void addNode(LinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode pre = node.pre;
        LinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private LinkedNode popTail() {
        LinkedNode last = tail.pre;
        removeNode(last);
        return last;
    }

    public LRUCache_146(int capacity) {
        this.map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;

        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
            if (size == capacity) {
                LinkedNode tail = popTail();
                map.remove(tail.key);
            }
            else {
                size++;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }
}


//此题的调库方法，linkedhashmap 一种LRU实现
// class LRUCache EXTENDS LinkedHashMap<Integer, Integer> {
//     private int capacity;

//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//      @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity; 
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */