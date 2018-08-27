package com.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class TreeViews {

  public static void main(String[] args) {
    /*
     *          1
     *         / \
     *        2   3
     *         \
     *          4
     *           \
     *            5
     *             \
     *              6    
     */
    Node root1 = new Node(1, new Node(2, null, new Node(4, null, new Node(5, null, new Node(6, null, null)))), new Node(3, null, null));
    System.out.println("********** Tree One **********");
    TreeViews tv1 = new TreeViews();
    System.out.println("Top View:");
    tv1.topView(root1);  // 1 2 3 6
    System.out.println("\n\nBottom View:");
    tv1.bottomView(root1); // 2 4 5 6
    System.out.println("\n\nLeft View:");
    tv1.leftView(root1); // 1 2 4 5 6
    System.out.println("\n\nRight View:");
    tv1.rightView(root1); // 1 3 4 5 6
    
    /*
     *                20
     *               /    \
     *             8       22
     *           /   \    /   \
     *         5      3 4     25
     *               / \      
     *             10    14 
     */
    Node root2 = new Node(20, new Node(8, new Node(5, null, null), new Node(3, new Node(10, null, null), new Node(14, null, null))), new Node(22, new Node(4, null, null), new Node(25, null, null)));
    System.out.println("\n\n********** Tree Two **********");
    TreeViews tv2 = new TreeViews();
    System.out.println("Top View:");
    tv2.topView(root2);  // 20 8 22 5 25 
    System.out.println("\n\nBottom View:");
    tv2.bottomView(root2); // 5 10 4 14 25  (4 will be printed and not 3 because we print what comes last)
    System.out.println("\n\nLeft View:");
    tv2.leftView(root2); // 20 8 5 10
    System.out.println("\n\nRight View:");
    tv2.rightView(root2); // 20 22 25 14
    
  }
  
  private void topView(Node root) {
    if(root == null) return;
    
    Set<Integer> set = new HashSet<>();
    Queue<QNode> q = new LinkedList<>();
    QNode qnRoot = new QNode(root, 0);
    q.add(qnRoot);
    while(!q.isEmpty()) {
      QNode qn = q.poll();
      if(!set.contains(qn.hd)) {
        System.out.print(qn.node.val + " ");
        set.add(qn.hd);
      }
      if(qn.node.left != null) {
        QNode qnl = new QNode(qn.node.left, qn.hd-1);
        q.add(qnl);
      }
      if(qn.node.right != null) {
        QNode qnr = new QNode(qn.node.right, qn.hd+1);
        q.add(qnr);
      }
    }
  }
  
  /**
   * Note: If there are multiple nodes at same horizontal distance then last node will be printed.
   */
  private void bottomView(Node root) {
    if(root == null) return;

    TreeMap<Integer, Integer> map = new TreeMap<>();
    Queue<QNode> q = new LinkedList<>();
    QNode qnRoot = new QNode(root, 0);
    q.add(qnRoot);
    while(!q.isEmpty()) {
      QNode qn = q.poll();
      map.put(qn.hd, qn.node.val);
      if(qn.node.left != null) {
        QNode qnl = new QNode(qn.node.left, qn.hd-1);
        q.add(qnl);
      }
      if(qn.node.right != null) {
        QNode qnr = new QNode(qn.node.right, qn.hd+1);
        q.add(qnr);
      }
    }
    
    Set<Entry<Integer, Integer>> set = map.entrySet();
    Iterator<Entry<Integer, Integer>> it = set.iterator();
    while(it.hasNext()) {
      System.out.print(it.next().getValue() + " ");
    }
  }
  
  private void leftView(Node root) {
    // Traverse the tree level by level and print first element of every level
    if(root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      Node n = q.peek();
      System.out.print(n.val + " ");
      List<Node> nodes = new ArrayList<>();
      while(!q.isEmpty()) {
        n = q.poll();
        if(n.left != null) nodes.add(n.left); 
        if(n.right != null) nodes.add(n.right);
      }
      q.clear();
      q.addAll(nodes);
    }
  }

  private void rightView(Node root) {
    // Traverse the tree level by level and print last element of every level
    if(root == null) return;
    Stack<Node> s = new Stack<>();
    s.push(root);
    while(!s.empty()) {
      Node n = s.peek();
      System.out.print(n.val + " ");
      List<Node> nodes = new ArrayList<>();
      while(!s.empty()) {
        n = s.pop();
        if(n.left != null) nodes.add(n.left); 
        if(n.right != null) nodes.add(n.right); 
      }
      s.clear();
      s.addAll(nodes);
    }
  }
}

/**
 * Representation of a tree Node.
 */
class Node {
  int val;
  Node left;
  Node right;
  
  Node(int data, Node l, Node r) {
    val = data;
    left = l;
    right = r;
  }
}

/**
 * Wrapper around the tree Node to include its horizontal distance.
 */
class QNode {
  Node node;
  int hd;
  
  QNode(Node n, int d) {
    node = n;
    hd = d;
  }
}
