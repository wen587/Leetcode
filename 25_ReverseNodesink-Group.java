// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int cnt = 0;
        while(fast != null) {
            if(cnt == k) {
                ListNode start = slow.next;
                ListNode end = fast;
                fast = end.next;
                
                ListNode n1 = start;
                ListNode n2 = n1.next;
                while(n1 != end) {
                    ListNode temp = n2.next;
                    n2.next = n1;
                    n1 = n2;
                    n2 = temp;
                }
                slow.next = end;
                start.next = fast;
                slow = start;
                fast = start;
                
                cnt = 0;
            } else {
                cnt++;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}