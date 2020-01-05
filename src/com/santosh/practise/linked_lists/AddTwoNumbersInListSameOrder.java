package com.santosh.practise.linked_lists;

public class AddTwoNumbersInListSameOrder {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(5);
        n1.next = new ListNode(6);
        n1.next.next = new ListNode(3);


        ListNode n2 = new ListNode(8);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(2);

        findSumOfLists(n1, n2);
    }

    private static void findSumOfLists(ListNode n1, ListNode n2) {

    }
}
