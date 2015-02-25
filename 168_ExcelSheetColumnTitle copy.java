/* Write a program to find the node at which the intersection of two singly 
 * linked lists begins.
 * For example, the following two linked lists:
 * A:            a1 ¡ú a2
 *                       ¨K
 *                         c1 ¡ú c2 ¡ú c3
 *                       ¨J            
 * B:     b1 ¡ú b2 ¡ú b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function 
 * returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
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

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = length(headA);
        int lenB = length(headB);
        
        if(lenA > lenB) {
            int step = lenA - lenB;
            while(step > 0) {
                headA = headA.next;
                step--;
            }
        }
        if(lenB > lenA) {
            int step = lenB - lenA;
            while(step > 0) {
                headB = headB.next;
                step--;
            }
        }
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != null) {
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
    private int length(ListNode head) {
        int len = 1;
        while(head.next != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}