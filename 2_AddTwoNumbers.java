/*
 * You are given two linked lists representing two non-negative numbers. The 
 * digits are stored in reverse 
 * order and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8 
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//666
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum %= 10;
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if(carry == 1) {
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
}
//recursive
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return stupid(l1, l2, 0);
    }
    private ListNode stupid(ListNode l1, ListNode l2, int carry) {
        if(l1 == null) {
            return carry == 0 ? l2 : stupid(new ListNode(carry), l2, 0);
        }
        if(l2 == null) {
            return carry == 0 ? l1 : stupid(l1, new ListNode(carry), 0);
        }
        int sum = l1.val + l2.val + carry;
        carry = sum / 10;
        ListNode node = new ListNode(sum % 10);
        node.next = stupid(l1.next, l2.next, carry);
        return node;
    }
}