package com.santosh.practise.linked_lists;

public class IntersectionPoint {
    public static void main(String[] args) {


        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(3);
        n2.next.next.next = new ListNode(4);
        n2.next.next.next.next = new ListNode(8);

        ListNode n1 = new ListNode(5);
        n1.next = new ListNode(7);
        //n1.next.next = n2.next.next.next;

        ListNode intersectionPoint = findIntersectionPoint(n1, n2);
        System.out.println(intersectionPoint.val);

        //System.out.println("Intersection point is:" + intersectionPoint == null ? "null" : intersectionPoint.val);
    }

    private static ListNode findIntersectionPoint(ListNode n1, ListNode n2) {
        if(n1 == null || n2 == null) {
            return null;
        }

        ListNode head1 = n1;
        ListNode head2 = n2;

        int length1 = 0;
        int length2 = 0;

        while (n1 != null) {
            length1++;
            n1 = n1.next;
        }
        while (n2 != null) {
            length2++;
            n2 = n2.next;
        }

        if(length1 >= length2) {
            int diff = length1 - length2;
            int counter = 0;
            while (counter != diff) {
                counter++;
                head1 = head1.next;
            }
        } else {
            int diff = length2 - length1;
            int counter = 0;
            while (counter != diff) {
                counter++;
                head2 = head2.next;
            }
        }

        while ((head1 != head2) && (head1 != null && head2 != null)) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1 == null || head2 == null) {
            return null;
        }
        return head1;
    }
}
