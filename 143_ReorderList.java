// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
//hashmap

public class Solution {
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int len = 0;
        ListNode node = head;
        while(node != null) {
            map.put(len, node);
            node = node.next;
            len++;
        }
        int i = 0;
        int j = len - 1;
        for(; i < j - 1; i++, j--) {
            ListNode temp = map.get(i).next;
            map.get(i).next = map.get(j);
            map.get(j).next = temp;
            map.get(j-1).next = null;
        }
    }
}
//my O(n^2) answer not accepted
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode node = head;
        while(node.next.next != null) {
            node = node.next;
        }
        node.next.next = head.next;
        head.next = node.next;
        node.next = null;
        reorderList(head.next.next);
    }
}

//Stack 
先用一个stack存放从后往前的节点。然后一条路线是从原链表的head开始往后遍历，
每次元素为cur，另一条路线是从stack里面pop出元素n，每次每条路线各取一个节点放
到一起。注意处理特殊情形，在链表结点为奇数个时，会出现cur==n；在链表节点为偶数
时，当次迭代执行完毕后cur.next==n。

public class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null) {
            stack.push(cur);
            cur = cur.next;
        }
         
        cur = head;
        while (cur!=null) {
            ListNode n = stack.pop();
            if (cur!=n) {
                ListNode temp = cur;
                cur = cur.next;
                temp.next = n;
                n.next = cur;
                if (cur.next==n) {
                    cur.next = null;
                    break;
                }
            } else {
                cur.next = null;
                break;
            }
        }
    }
}
// First, find the second half of List, (slow and fast pointer) reverse 
// it, and make the end of first half point to null
// Second, insert second half node into first half of List
// For Example: If we have 1 - 2 - 3 - 4 - 5, reverse 4 - 5 to 5 - 4,
//  make the first half end to null
// Now We have 1 - 2 - 3 and 5 - 4, Insert each of second list node 
// into the first list between current and next node which gives 
// 1 - 5 - 2 - 4 - 3

public void reorderList(ListNode head) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    if (head == null || head.next == null) return;
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode reverseHead = slow.next;           // find the second half of list
    slow.next = null;                           // make first half end point to null
    reverseHead = reverse(reverseHead);         // reverse second half     
    ListNode cur = head;        
    while(reverseHead != null) {                // link together
        ListNode tmp = reverseHead.next;
        reverseHead.next = cur.next;
        cur.next = reverseHead;
        cur = cur.next.next;
        reverseHead = tmp;
    }
}
private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = new ListNode(0);
    prev.next = head;
    head = prev;
    ListNode cur = prev.next;
    while(cur.next != null) {
        ListNode tmp = cur.next;
        cur.next = tmp.next;
        tmp.next = prev.next;
        prev.next = tmp;
    }
    return prev.next;
}

//good answer but hard to understand
//1. find the middle node
//2. reverse the right side of the list
//3. merger the left side list and right side list


    public class Solution {
        public void reorderList(ListNode head) {
            if(head==null) return;
            ListNode slow = head, fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow, cur = slow.next;
            if(cur!=null){ //split the list to two
                ListNode tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }
            while(cur!=null){
                ListNode tmp = cur.next;
                cur.next = mid.next;
                mid.next = cur;
                cur = tmp;
            }
            ListNode left = head, right = mid.next;
            while(right!=null){
                mid.next = right.next;
                right.next = left.next;
                left.next = right;
                left = right.next;
                right = mid.next;
            }

        }
    }
