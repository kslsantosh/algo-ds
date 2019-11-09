package com.santosh.practise.linked_lists;

import java.util.List;

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int n = 2;
        ListNode listNode = removeNthNodeFromEnd(head, n);

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
}
