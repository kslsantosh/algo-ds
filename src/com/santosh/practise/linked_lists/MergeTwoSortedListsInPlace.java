package com.santosh.practise.linked_lists;

import java.util.List;

public class MergeTwoSortedListsInPlace {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(4);

        ListNode head = mergeTwoLists(n1, n2);

        System.out.println("Merged List is:");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if(n1 == null && n2 == null) {
            return null;
        }
        if(n1 == null) return n2;
        else if (n2 == null) return n1;

        ListNode head = n1.val < n2.val ? n1 : n2;
        if(n1.val == n2.val) {
            head = n2;
        }
        ListNode previous = null;

        while(n1 != null || n2 != null) {

            if(n1 == null) {
                previous.next = n2;
                return head;
            } else if (n2 == null) {
                return head;
            }

            if(n2.val <= n1.val) {
                // we need to take the current element of n2 and append it to the 1st list
                ListNode temp = n2.next;
                if(previous == null) {
                    n2.next = n1;
                    previous = n2;
                } else {
                    previous.next = n2;
                    previous = n2;
                    n2.next = n1;
                }
                n2 = temp;
            }
            else {
                previous = n1;
                n1 = n1.next;
            }
        }
        return head;
    }
}
