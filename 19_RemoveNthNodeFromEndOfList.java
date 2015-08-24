/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
//My simple slt using dummy node and two pointer
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n-- > 0) {
            fast = fast.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
//cnt length
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)return head;
        int len=1;
        ListNode cntLen = head;
        while(cntLen.next != null) {
            cntLen = cntLen.next;
            len++;
        }
        if(n == len) return head.next;
        int i = 1;
        ListNode cutNode = head;
        while(i < len - n) {
            cutNode = cutNode.next;
            i++;
        }
        cutNode.next = cutNode.next.next;
        return head;
    }
}
