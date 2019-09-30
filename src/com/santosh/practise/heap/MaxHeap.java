package com.santosh.practise.heap;

import java.util.Arrays;

public class MaxHeap {
    static int[] heap = new int[0];
    static int maxLength = heap.length;
    public static void main(String[] args) {
        insert(10);
        insert(5);
        insert(3);
        insert(2);
        insert(4);
        insert(15);

        remove();
        remove();
        remove();
        remove();
        remove();
        remove();
    }

    private static void remove() {
        int firstElement = heap[0];
        int lastElement = heap[maxLength-1];
        System.out.println("Element removed" + firstElement);
        // swap first with last
        heap[0] = lastElement;
        heap[maxLength-1] = firstElement;

        maxLength = maxLength -1;
        heapifyOnDelete(0, maxLength);
    }

    private static void heapifyOnDelete(int startingPoint, int maxLength) {
        int leftChildLocation = startingPoint*2 + 1;
        int rightChildLocation = startingPoint*2 + 2;

        if(leftChildLocation > maxLength-1 && rightChildLocation > maxLength-1) {
            return;
        }

        int largest = heap[startingPoint];
        int largestLocation = startingPoint;

        if(leftChildLocation <= maxLength-1 && heap[leftChildLocation] > largest) {
            largest = heap[leftChildLocation];
            largestLocation = leftChildLocation;
        }
        if(rightChildLocation <= maxLength-1 && heap[rightChildLocation] > largest) {
            largest = heap[rightChildLocation];
            largestLocation = rightChildLocation;
        }

        if(largest == heap[startingPoint]) {
            return;
        }

        // swap starting point and largest
        int temp = heap[startingPoint];
        heap[startingPoint] = heap[largestLocation];
        heap[largestLocation] = temp;

        // now call heapify with starting point as where the swap happened
        heapifyOnDelete(largestLocation, maxLength);
    }

    public static void insert(int elementToInsert) {
        // increase the size of heap
        int newLength = heap.length + 1;
        maxLength++;

        // create a new heap of 1 length more and copy the existing elements into it.
        heap = Arrays.copyOf(heap, newLength);
        heap[newLength-1] = elementToInsert;
        heapifyOnInsert(newLength-1);

        System.out.println("After insertion the heap is");
        for(int i : heap) {
            System.out.print(i  + " ,");
        }
        System.out.println();
    }

    private static void heapifyOnInsert(int placeToHeapify) {
        int parent = (placeToHeapify-1)/2;

        // check if it's parent is less than the current inserted element
        if(parent == placeToHeapify) {
            return;
        }
        // swap if parent is less than the current element
        if(heap[parent] < heap[placeToHeapify]) {
            int temp = heap[placeToHeapify];
            heap[placeToHeapify] = heap[parent];
            heap[parent] = temp;
            // again heapify for its parent.
            heapifyOnInsert(parent);
        }
    }
}
