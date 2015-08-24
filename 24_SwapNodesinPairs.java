// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


//iterative O(1) sapce
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode list = head.next;
        ListNode res = head;
        ListNode conn = null;
        while(res != null && res.next != null) {
            ListNode temp = res.next;
            res.next = temp.next;
            temp.next = res;
            if(conn != null) {
                conn.next = temp;
            } 
            conn = res;
            res = res.next;
        }
        return list;
    }
}

//dummy nodes
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
    }
    return dummy.next;
}


//recursive

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head.next;
        head.next = swapPairs(head.next.next);
        res.next = head;
        return res;
        
    }
}