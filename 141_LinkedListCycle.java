/*
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space? 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//记得判断fast.next fast.next.next都不为null
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null) {
            fast = fast.next.next;
            if(fast == null) return false;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}