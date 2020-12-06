package com.santosh.practise.linked_lists;

public class MergeTwoSortedListsInPlace2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);


        ListNode n2 = new ListNode(3);


        ListNode head = mergeTwoSortedInPlace(n1, n2);

        System.out.println("Merged List is:");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode mergeTwoSortedInPlace(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head;
        if(l1.val < l2.val) {
            head = l1;
        } else {
            head = l2;
        }

        ListNode prev = head;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                // we need to increment list one to next node. And store
                prev = l1;
                l1 = l1.next;
            }
            else if (l1.val >= l2.val) {
                // detatch node from l2 and add it to l1.
                ListNode nodeOfL2 = l2;
                ListNode l2Next = l2.next;
                prev.next = nodeOfL2;
                nodeOfL2.next = l1;
                prev = nodeOfL2;
                l2 = l2Next;
            }
        }

        if(l1 == null) prev.next = l2;


      return head;

    }
}
