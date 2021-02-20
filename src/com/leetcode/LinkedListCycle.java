package com.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

  public static void main(String[] args) {
    LinkedListCycle llc = new LinkedListCycle();

    ListNode n1 = new ListNode(10);
    ListNode n2 = new ListNode(20);
    n1.next = n2;
    n2.next = n1;
    System.out.println("Has Cycle: " + llc.hasCycle(n1) +
                      " Cycle Started at Node: " + llc.detectCycle(n1).val);
    
    ListNode l1 = new ListNode(10);
    ListNode l2 = new ListNode(20);
    ListNode l3 = new ListNode(30);
    ListNode l4 = new ListNode(40);
    ListNode l5 = new ListNode(50);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l3;
    System.out.println("Has Cycle: " + llc.hasCycle(l1) +
                      " Cycle Started at Node: " + llc.detectCycle(l1).val);
    
        
    ListNode x1 = new ListNode(3);
    ListNode x2 = new ListNode(2);
    ListNode x3 = new ListNode(0);
    ListNode x4 = new ListNode(-4);
    x1.next = x2;
    x2.next = x3;
    x3.next = x4;
    x4.next = x2;
    System.out.println("Has Cycle: " + llc.hasCycle(x1) +
        " Cycle Started at Node: " + llc.detectCycle(x1).val);

  }

  /**
   * Checks if the given linked list has Cycle.
   */
  private boolean hasCycle(ListNode head) {
    if (head == null || head.next == null)
      return false;
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow != null && fast != null && slow.next == fast.next) return true;
    }
    return false;
  }
  
  /**
   * Checks if the given linked list has Cycle and if
   * it has then returns the node where the cycle starts.
   */
  private ListNode detectCycle(ListNode head) { 
    if (head == null || head.next == null) return null;
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow != null && fast != null && slow.next == fast.next) { // Cycle Found
        fast = head;
        while(fast.next != null) { // Find start of Cycle
          if(fast == slow) return fast;
          if(fast.next == slow.next) return fast.next;
          fast = fast.next;
          slow = slow.next;
        }
      }
    }
    return null;
  }
}


class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}
