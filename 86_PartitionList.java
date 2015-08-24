/*
 * Given a linked list and a value x, partition it such that all 
 * nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
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
//My one pass 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode temp = head;
        while(pre.next != null && pre.next.val < x) {
                pre = pre.next;
        }
        ListNode cur = pre.next;
        while(cur != null && cur.next != null) {
            while(cur.next != null && cur.next.val >= x) {
                cur = cur.next;
            }
            if(cur.next == null) return dummy.next;
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp;
        }
        return dummy.next;
    }
}





//懂啦
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}