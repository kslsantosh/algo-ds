package com.santosh.practise.linked_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseInGroupsOfK {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 10;
        ListNode listNode = reverseInGroupsOfK(head, k);

        System.out.println("Result::");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode reverseInGroupsOfK(ListNode head, int k) {

        if(head == null) return null;
        if(k == 1) return head;

        Queue<ListNode> starts = new LinkedList<>();
        Queue<ListNode> ends = new LinkedList<>();
        ListNode prev = null;

        //starts.add(null);

        int counter = 1;

        while(head != null) {
            if(counter == 1) {
                starts.add(head);
                ListNode temp = head.next;
                head.next = null;
                prev = head;
                head = temp;
                counter++;
            }
            else if (counter == k) {
                ListNode temp = head.next;
                if(temp != null) {
                    ends.add(head); // the case when k = length of list , then anyway we are adding last element to ends.
                }
                head.next = prev;
                prev = head;
                head = temp;
                counter = 1; // reset the counter back to 1
            }
            else {
                // pointer is between 1 to k
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
                counter++;
            }
        }
        System.out.println("Prev at this point " + prev.val);

        ends.add(prev); // add the last element to ends

        ListNode mainHead = ends.poll();

        System.out.println("Starts");
        for (ListNode start : starts) {
            if(start == null) {
                System.out.println("null");
            } else {
                System.out.println(start.val);
            }
        }
        System.out.println("Ends");
        for (ListNode end : ends) {
            if(end == null) {
                System.out.println("null");
            } else {
                System.out.println(end.val);
            }
        }
        while (! starts.isEmpty()) {
            ListNode s = starts.poll();
            ListNode e = ends.poll();
            s.next = e;
        }

        // now start assigning

        return mainHead;
    }
}
