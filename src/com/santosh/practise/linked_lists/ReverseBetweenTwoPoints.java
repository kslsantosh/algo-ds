package com.santosh.practise.linked_lists;

/**
 * LeetCode 92
 */
public class ReverseBetweenTwoPoints {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int m = 3;
        int n = 4;
        //ListNode listNode = removeBetweenTwoPoints(head, m, n);
        ListNode listNode = reverseBetweenTwoNodes2(head, m, n);

        System.out.println("Result::");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode removeBetweenTwoPoints(ListNode head, int m, int n) {
        if(head == null)  return null;
        if(m == n) return head;

        ListNode startingPoint = head;
        ListNode s1 = null,s2,e1,e2,prev = null;
        int counter = 1;

        while (head != null && counter != m) {
            s1 = head;
            head = head.next;
            counter++;
        }
        s2 = head;

        while (head != null && counter != n+1) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            counter++;
        }
        e1 = prev;
        e2 = head;

        System.out.println("s1::" + s1.val);
        System.out.println("s2::" + s2.val);
        System.out.println("e1::" + e1.val);
        System.out.println("e2::" + e2.val);

        if(s1 != null && s2 != null) {
            s1.next = e1;
            s2.next = e2;
            return startingPoint;
        }

        if(s1 == null && e2 == null) {
            return e1;
        }
        else if(s1 == null) {
            s2.next = e2;
            return e1;
        } else { // only e2 == null
            s1.next = e1;
            return s1;
        }
    }


    public static ListNode reverseBetweenTwoNodes2(ListNode head, int m, int n) {

        ListNode newHead = head;

        if(m==n) return head;

        ListNode attachHead = null;
        ListNode attachTail = null;

        int counter = 1;

        while (counter < m) {
            counter++;
            attachHead = head;
            head = head.next;
        }

        // now counter is at m, and head is also at node m.
        ListNode prev = null;
        ListNode endOfReversedList = null;

        while (counter < n) {
            ListNode next = head.next;
            head.next = prev;
            if(prev == null) {
                // this is the end of the reversed linked list
                endOfReversedList = head;
            }
            prev = head;
            head = next;
            counter++;
        }

        // head is now at 4.
        attachTail = head.next;
        head.next = prev;

        attachHead.next = head;
        attachTail.next = endOfReversedList;

        return newHead;

    }
}
