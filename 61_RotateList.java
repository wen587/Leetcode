/*
 * Given a list, rotate the list to the right 
 * by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
//count length
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return head;
        int length = 1;
        ListNode node = head;
        while(node.next != null) {
            length++;
            node = node.next;
        }
        node.next = head;
        int m = n % length;
        for(int i=0; i<length-m; i++) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
//two pointer got time exceed;
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        int i = 0;
        while(i < k) {
            if (fast.next == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
            i++;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
            fast.next = head;
            slow.next = temp;
            slow.next = null;
        
        return temp;
    }
}

//stack solution 
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (null==head)
            return head;
             
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node!=null) {
            stack.push(node);
            node = node.next;
        }
             
        n = n % stack.size();
        if (n==0)
            return head;
         
        ListNode tail = stack.peek();
        for (int i=n; i>0; i--)
            node = stack.pop();
         
        stack.peek().next = null;
        tail.next = head;
         
        return node;
    }
}