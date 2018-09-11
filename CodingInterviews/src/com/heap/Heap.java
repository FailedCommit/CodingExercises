package com.heap;

import java.util.Arrays;

/**
 * Demonstrates a Max-Heap.
 */
public class Heap {
  private Integer[] heap;
  private int currentPosition = -1;

  public Heap(int size) {
    this.heap = new Integer[size];
  }

  public void insert(int item) {
    if (isFull()) throw new RuntimeException("Heap is full...");

    this.heap[++currentPosition] = item;
    percolateUp(currentPosition);
  }

  public int getMax() {
    int result = this.heap[0];
    this.heap[0] = this.heap[currentPosition--];
    this.heap[currentPosition + 1] = null; // avoid obsolete references
    percolateDown(0, -1);
    return result;
  }

  public void heapsort() {
    for (int i = 0; i <= currentPosition; i++) {
      swap(heap, 0, currentPosition - i);
      percolateDown(0, currentPosition - i - 1);
    }
  }
  
  private void percolateUp(int index) {
    int parentIndex = (index - 1) / 2;

    while (parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {
      swap(heap, index, parentIndex);
      index = parentIndex;
      parentIndex = (index - 1) / 2;
    }
  }

  private void percolateDown(int fromIndex, int uptoIndex) {
    if (uptoIndex < 0) uptoIndex = currentPosition;

    while (fromIndex <= uptoIndex) {
      int leftChildIndex = 2 * fromIndex + 1;
      int rightChildIndex = 2 * fromIndex + 2;

      if (leftChildIndex <= uptoIndex) {
        int childToSwapIndex;
        if (rightChildIndex > uptoIndex) childToSwapIndex = leftChildIndex;
        else childToSwapIndex = (this.heap[leftChildIndex] > this.heap[rightChildIndex]) ? leftChildIndex : rightChildIndex;
        if (this.heap[fromIndex] < this.heap[childToSwapIndex]) swap(heap, fromIndex, childToSwapIndex);
        else break;
        fromIndex = childToSwapIndex;
      } else {
        break;
      }
    }
  }

  private boolean isFull() {
    return this.currentPosition == this.heap.length;
  }

  private void swap(Integer[] a, int srcIndex, int destIndex) {
    Integer temp = a[srcIndex];
    a[srcIndex] = a[destIndex];
    a[destIndex] = temp;
  }

  public static void main(String[] args) {
    Heap heap = new Heap(6);
    heap.insert(10);
    heap.insert(5);
    heap.insert(20);
    heap.insert(3);
    heap.insert(4);
    heap.insert(30);

    System.out.println("Heap Created: " + Arrays.toString(heap.heap));
    System.out.println("Max: " + heap.getMax());
    System.out.println("Heap after removing the max element: " + Arrays.toString(heap.heap));
    heap.heapsort();
    System.out.println("Heap after sorting: " + Arrays.toString(heap.heap));

  }
}