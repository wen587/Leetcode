// Given a singly linked list, determine if it is a palindrome.

// Follow up:
// Could you do it in O(n) time and O(1) space?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode s = head;
        ListNode f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        s.next = Palindrome(s.next, null);
        s = s.next;
        while(s != null) {
            if(s.val != head.val) return false;
            s = s.next;
            head = head.next;
        }
        return true;
    }
    public ListNode Palindrome(ListNode head, ListNode newHead) {
        if(head == null) return newHead;
        ListNode temp = head.next;
        head.next = newHead;
        return Palindrome(temp, head);
    }
}