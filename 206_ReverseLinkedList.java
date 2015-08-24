// Reverse a singly linked list.



//iterative
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode end = head;
        curr = head.next;
        while(curr != null) {
            
            ListNode temp = curr.next;
            curr.next = head;
            head = curr;
            curr = temp;
        }
        end.next = null;
        return head;
    }
}
//simple iterative  
public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while(head != null){
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}


//recursive
public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    private ListNode reverse(ListNode head, ListNode newHead) {
        if(head == null) return newHead;
        ListNode temp = head.next;
        head.next = newHead;
        return reverse(temp, head);
        
    }
}