package com.leetcode.linkedlist;

public class LinkedListIntersection {

  public static void main(String[] args) {
    LinkedListIntersection lli = new LinkedListIntersection();

    ListNode intersection = new ListNode(40, new ListNode(50, new ListNode(60, null)));
    ListNode headA = new ListNode(10, new ListNode(20, new ListNode(30, intersection)));
    ListNode headB = new ListNode(111, intersection);
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNode(headA, headB)); // 40
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNodeImproved(headA, headB)); // 40

    ListNode intersectionXY = new ListNode(1, null);
    ListNode headX = intersectionXY;
    ListNode headY = intersectionXY;
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNode(headX, headY)); // 1
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNodeImproved(headX, headY)); // 1

    ListNode intersectionMN = new ListNode(45, new ListNode(50, new ListNode(60, null)));
    ListNode headM = intersectionMN;
    ListNode headN = new ListNode(10, new ListNode(20, new ListNode(30, intersectionMN)));
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNode(headM, headN)); // 45
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNodeImproved(headM, headN)); // 45

    // No intersection
    ListNode headC = new ListNode(10, new ListNode(20, new ListNode(30, null)));
    ListNode headD = new ListNode(111, null);
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNode(headC, headD)); // null
    System.out.println("Given lists converge at Node : " + lli.getIntersectionNodeImproved(headC, headD)); // null
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    if (headA == headB) return headA;
    if (headA.next == headB) return headB;
    if (headB.next == headA) return headA;
    int lenA = 0;
    int lenB = 0;
    ListNode tempA = headA;
    ListNode tempB = headB;
    while (tempA != null) {
      lenA++;
      tempA = tempA.next;
    }
    while (tempB != null) {
      lenB++;
      tempB = tempB.next;
    }

    int diff = lenA > lenB ? lenA - lenB : lenB - lenA;
    tempA = headA;
    tempB = headB;

    if (lenA > lenB) {
      while (diff > 0) {
        tempA = tempA.next;
        diff--;
      }
    } else {
      while (diff > 0) {
        tempB = tempB.next;
        diff--;
      }
    }
    while (tempA != null && tempB != null && tempA.next != tempB.next) {
      tempA = tempA.next;
      tempB = tempB.next;
    }
    if (tempA == null || tempA == tempB) return tempA;
    return tempA.next;
  }

  public ListNode getIntersectionNodeImproved(ListNode headA, ListNode headB) {
    ListNode tempA = headA;
    ListNode tempB = headB;

    while (tempA != tempB) {
      tempA = tempA == null ? headB : tempA.next;
      tempB = tempB == null ? headA : tempB.next;
    }
    return tempB;
  }


  // Inner Class
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode [" + val + "]";
    }
  }
}
