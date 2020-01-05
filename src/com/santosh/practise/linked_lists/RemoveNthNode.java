package com.santosh.practise.linked_lists;

import java.util.List;

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 5;
        //ListNode listNode = removeNthNodeFromEnd(head, n);
        ListNode listNode = removeNthNodeFromEndApproach2(head, n);
        System.out.println("Result::");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode headRef = head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        if(head == null || n == 0) {
            return headRef;
        }
        ListNode previous = null;

        int counter = 1;

        while(counter != n) {
            if(pointer2.next != null) {
                pointer2 = pointer2.next;
                counter++;
            } else {
                return headRef;
            }
        }

        while(pointer2.next != null) { // going till the end of the linked list. moving both pointers
            pointer2 = pointer2.next;
            ListNode temp = pointer1;
            pointer1 = pointer1.next;
            previous = temp;
        }

        if (previous == null) System.out.println("Null");
        else System.out.println(previous.val);


        System.out.println(pointer1.val);
        System.out.println(pointer2.val);


        // now node @ pointer 1 is the node to remove
        //pointer1.next = null;
        if(previous == null) {
            return pointer1.next; // removing first node.
        } else if (pointer1.equals(headRef)) {
            return pointer1.next;
        }else if(pointer1 == pointer2) {
            previous.next = null;
        } else {
            previous.next = pointer1.next;
        }

        return headRef;
    }

    private static ListNode removeNthNodeFromEndApproach2(ListNode head, int n) {
        if(head == null || n == 0) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = head;

        while (n != 0) {
            head2 = head2.next;
            n--;
            if(head2 == null && n == 0) {
                return head1.next; // removing the first node
            } else if(head2 == null && n > 0) {
                return head; // n value is greater than length of list
            }
        }

        while (head2.next != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        head1.next = head1.next.next;

        return head;
    }
}
