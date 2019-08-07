/*
Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null (Java), false (C++), -1(Python).
*/

public class Solution<K, V> {
  // limit is the max capacity of the cache
  private int limit;
  private Map<K, Node> map;
  private Node head;
  private Node tail;
  public Solution(int limit) {
    this.limit = limit;
    map = new HashMap<>();
  }
  
  public void set(K key, V value) {
    Node n = map.get(key);
    if (n == null) {
      if (map.size() == limit) {
        removeNode(tail.key);
      }
      map.put(key, n);
      n = new Node(key, value);
    } else {
      n.value = value;
      n = removeNode(key);
    }
    addNodeToHead(n);    
  }
  
  public V get(K key) {
    if (map.containsKey(key)) {
      Node n = this.removeNode(key);
      this.addNodeToHead(n);
      return n.value;
    }
    return null;
  }

  private Node removeNode(K key) {
    Node n = map.remove(key);
    if (n == null) {
      return null;
    } else if (head == n && tail == n) {
      head = null;
      tail = null;
    } else if (head == n) {
      head = n.next;
      head.prev = null;
      n.next = null;
    } else if (tail == n) {
      tail = n.prev;
      tail.next = null;
      n.prev = null;
    } else {
      n.prev.next = n.next;
      n.next.prev = n.prev;
      n.next = null;
      n.prev = null;
    }
    return n;
  }

  private void addNodeToHead(Node n) {
    map.put(n.key, n);
    if (head != null) {
      n.next = head;
      head.prev = n;
      head = n;
      if (map.size() > limit) {
        removeNode(tail.key);
      }
    } else {
      head = n;
      tail = n;
    }
  }

  class Node {
    public K key;
    public V value;
    public Node next;
    public Node prev;
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}
