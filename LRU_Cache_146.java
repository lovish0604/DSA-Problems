import java.util.*;

public class LRU_Cache_146 {
    HashMap<Integer, Node> map;
    int cap;
    Node head;
    Node tail;
    class Node {
        int name, data;
        Node next;
        Node previous;
        Node(int key, int val) {
            this.name = key;
            this.data = val;
        }
    }
    public LRU_Cache_146(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            add(temp);
            return temp.data;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.data = value;
            remove(temp);
            add(temp);
            return;
        }
        Node nn = new Node(key, value);
        map.put(key, nn);
        add(nn);
        if (map.size() > cap) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.name);
        }
    }
    void add(Node node) {
        Node last = tail.previous;
        last.next = node;
        node.previous = last;
        node.next = tail;
        tail.previous = node;
    }
    void remove(Node node) {
        Node before = node.previous;
        Node after = node.next;
        before.next = after;
        after.previous = before;
    }
}
