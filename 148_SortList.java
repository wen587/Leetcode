/* 
 * Sort a linked list in O(n log n) time using constant space complexity.
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
//cheat
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        cur = head;
        int i = 0;
        while (cur != null) {
            cur.val = list.get(i);
            cur = cur.next;
            i++;
        }
        return head;
    }
}


//归并
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode s = head;
        ListNode f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        f = s.next;
        s.next = null;
        s = head;
        s = sortList(s);
        f = sortList(f);
        return merge(s, f);
        
    }
    private ListNode merge(ListNode h1, ListNode h2) {
        // if(n1 == null) return n2;
        // if(n2 == null) return n1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                head.next = h1;
                h1 = h1.next;
            } else {
                head.next = h2;
                h2 = h2.next;
            }
            head = head.next;
        }
        if(h1 == null) {
            head.next = h2;
        } else if(h2 ==null) {
            head.next = h1;
        }
        return dummy.next;
    }
}
//易懂的归并
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
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }

            slow = slow.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        right = sortList(right);

        return mergeTwoLists(left, right);
    }
    
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode node = null;
        ListNode head = null;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (node == null) {
                    node = l1;
                    head = node;
                } else {
                    node.next = l1;
                    node = node.next;
                }

                l1 = l1.next;
            } else {
                if (node == null) {
                    node = l2;
                    head = node;
                } else {
                    node.next = l2;
                    node = node.next;
                }

                l2 = l2.next;
            }
        }

        if (l1 != null) {
            node.next = l1;
        } else if (l2 != null) {
            node.next = l2;
        }

        return head;
    }
}