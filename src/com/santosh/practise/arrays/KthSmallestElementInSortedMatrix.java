package com.santosh.practise.arrays;

import java.util.PriorityQueue;

/**
 * LeetCode problem 378
 */
public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        int[][] matrix = {{1,  5,  9},{10, 11, 13},{12, 13, 15}};
        int kThSmallestElement = getKthSmallestElementFromSortedMartix(matrix, k);
        System.out.println("K th Smallest Element is::" + kThSmallestElement);
    }

    private static int getKthSmallestElementFromSortedMartix(int[][] matrix, int k) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] visited = new int[numRows][numCols];

        int removedCount = 0;
        PriorityQueue<DriverLargestSumContiguousSubarray.HeapNode> minHeap = new PriorityQueue<DriverLargestSumContiguousSubarray.HeapNode>((o1, o2) -> o1.data - o2.data);
        minHeap.add(new DriverLargestSumContiguousSubarray.HeapNode(matrix[0][0], 0, 0));
        visited[0][0] = 1;
        DriverLargestSumContiguousSubarray.HeapNode lastRemovedElement = null;
        while(removedCount != k) {
            DriverLargestSumContiguousSubarray.HeapNode currentMinimumElement = minHeap.poll();
            int currentRow = currentMinimumElement.row;
            int currentColumn = currentMinimumElement.column;
            lastRemovedElement = currentMinimumElement;
            removedCount++;
            System.out.println("Removing:: " + currentMinimumElement.data);
            boolean isElementOnRightValidAndNotVisited = isElementOnRightValid(currentMinimumElement, numRows, visited);
            if(isElementOnRightValidAndNotVisited) {
                minHeap.add(new DriverLargestSumContiguousSubarray.HeapNode(matrix[currentRow+1][currentColumn], currentRow+1, currentColumn));
                System.out.println("Visited:: " + matrix[currentRow+1][currentColumn]);
                visited[currentRow+1][currentColumn] = 1;
            }

            boolean isElementOnBottomValidAndNotVisited = isElementOnBottomValid(currentMinimumElement, numCols, visited);
            if(isElementOnBottomValidAndNotVisited) {
                minHeap.add(new DriverLargestSumContiguousSubarray.HeapNode(matrix[currentRow][currentColumn+1], currentRow, currentColumn+1));
                System.out.println("Visited:: " + matrix[currentRow][currentColumn+1]);
                visited[currentRow][currentColumn+1] = 1;
            }
        }
        return lastRemovedElement.data;
    }

    private static boolean isElementOnRightValid(DriverLargestSumContiguousSubarray.HeapNode currentMinimumElement, int numRows, int[][] visited) {
        if(currentMinimumElement.row + 1 < numRows && visited[currentMinimumElement.row+1][currentMinimumElement.column] == 0) {
            return true;
        }
        return false;
    }

    private static boolean isElementOnBottomValid(DriverLargestSumContiguousSubarray.HeapNode currentMinimumElement, int numCols, int[][] visited) {
        if(currentMinimumElement.column + 1 < numCols && visited[currentMinimumElement.row][currentMinimumElement.column+1] == 0) {
            return true;
        }
        return false;
    }
}

