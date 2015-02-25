/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
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
//不明白 不是对head没有改变吗 为什么返回head
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            if(cur.val==next.val) cur.next = next.next;
            else cur = cur.next;
            next = next.next;
        }
        return head;
    }
}