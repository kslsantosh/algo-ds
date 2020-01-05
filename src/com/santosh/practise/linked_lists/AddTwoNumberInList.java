package com.santosh.practise.linked_lists;

import java.util.List;

public class AddTwoNumberInList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);


        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
//        n2.next.next.next = new ListNode(4);
//        n2.next.next.next.next = new ListNode(8);

        findSumOfLists(n1, n2);
    }

    private static void findSumOfLists(ListNode n1, ListNode n2) {
        int sum1 = findSum(n1, 0, 1);
        System.out.println("Sum= " + sum1);
        int sum2 = findSum(n2, 0, 1);
        System.out.println("Sum= " + sum2);
        int totalSum = sum1 + sum2;
        System.out.println("TotalSum= " + totalSum);
        ListNode head = prepareLinkedListFromSum(totalSum);

        System.out.println("Result::");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode prepareLinkedListFromSum(int totalSum) {
        ListNode head = new ListNode(totalSum % 10);
        totalSum = totalSum / 10;

        ListNode prev = head;

        while(totalSum != 0) {
            int remainder = totalSum % 10;
            totalSum = totalSum/10;

            ListNode newNode = new ListNode(remainder);
            prev.next = newNode;
            prev = prev.next;
        }
        return head;
    }

    private static int findSum(ListNode n, int sum, int multiplier) {
        if(n != null) {
            sum = sum + (n.val * multiplier);
            return findSum(n.next, sum, multiplier*10);
        }
        else {
            return sum;
        }
    }
}
