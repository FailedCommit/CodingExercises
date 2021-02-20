package com.leetcode.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  int capacity;
  Node head = null;
  Node end = null;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<Integer, Node>();
  }

  public int get(int key) {
    if(map.containsKey(key)) {
      Node n = map.get(key);
      remove(n);
      setHead(n);
      return n.value;
    }
    return -1;
  }

  public void remove(Node n) {
    if(n.pre != null) n.pre.next = n.next; // First Node
    else head = n.next;
    if(n.next!= null) n.next.pre = n.pre; // Last Node
    else end = n.pre;
  }

  public void setHead(Node n) {
    n.next = head;
    n.pre = null;
    if(head != null) head.pre = n;
    head = n;
    if(end == null) end = head;
  }

  public void put(int key, int value) {
    if(map.containsKey(key)) {
        Node old = map.get(key);
        old.value = value;
        remove(old);
        setHead(old);
    } else {
        Node created = new Node(key, value);
        if(map.size()>=capacity) {
            map.remove(end.key);
            remove(end);
            setHead(created);
        } else {
            setHead(created);
        }    
        map.put(key, created);
    }
  }
  
  public static void main(String[] args) {
    LRUCache cache = new LRUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1)); // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2)); // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
  }
}

class Node {
  int key;
  int value;
  Node pre;
  Node next;

  public Node(int key, int value){
      this.key = key;
      this.value = value;
  }
}