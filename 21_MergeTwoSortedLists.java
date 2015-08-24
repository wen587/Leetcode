/*
 * Merge two sorted linked lists and return it as a new list. The new list should 
 * be made by splicing together the nodes of the first two lists.
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
//recursive
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1 : l2);
        return dummy.next;
    }

//iterative
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = l1;
        dummy2.next = l2;
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        while(head1.next != null && head2.next != null) {
            if(head1.next.val < head2.next.val) {
                head1 = head1.next;
            } else {
                ListNode temp = head2.next.next;
                head2.next.next = head1.next;
                head1.next = head2.next;
                head1 = head1.next;
                head2.next = temp;
            }
        }
        if(head2.next != null) {
            head1.next = head2.next;
        }
        return dummy1.next;
    }