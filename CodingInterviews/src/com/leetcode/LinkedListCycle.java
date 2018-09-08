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
    System.out.println("Has Cycle: " + llc.hasCycle(n1));
    
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
    System.out.println("Has Cycle: " + llc.hasCycle(l1));

  }

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
}


class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}
