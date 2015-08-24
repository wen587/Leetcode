// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.


//Iterative
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0); 
        dummy.next= head;
        ListNode pre= dummy;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            } else pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
//recursive
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}