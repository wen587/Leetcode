// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

//iterarive
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                while( head.next != null && head.val == head.next.val ) {
                    head = head.next;
                }
                pre.next = head.next;
            } else {
                pre = head;
                
            }
            head = head.next;
            // pre = head.next;
        }
        return dummy.next;
    }
}

//recursive
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        if(head.next != null && head.val == head.next.val) {
            while(head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}