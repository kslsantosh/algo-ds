package com.santosh.practise.linked_lists;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode Problem 23
 */
public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[10];

        mergeKSortedLinkedLists(listNodes);
    }

    private static ListNode mergeKSortedLinkedLists(ListNode[] lists) {
        if(lists.length > 0) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            ListNode sortedList = new ListNode(0);
            ListNode currentPointer = sortedList;

            for (ListNode listNode : lists) {
                if(listNode != null) {
                    minHeap.add(listNode);
                }
            }

            while (!minHeap.isEmpty()) {
                ListNode currentNode = minHeap.peek();
                currentPointer.next = new ListNode(currentNode.val);
                ListNode nextNode = currentNode.next;

                minHeap.poll();
                if (nextNode != null) {
                    minHeap.add(nextNode);
                }
                currentPointer = currentPointer.next;
            }

            return sortedList.next;
        }
        return null;
    }
}
