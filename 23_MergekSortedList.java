/*
 * Merge k sorted linked lists and return it as one 
 * sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (null==lists || lists.isEmpty())
            return null;
         
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val==n2.val)
                    return 0;
                else if (n1.val<n2.val)
                    return -1;
                else
                    return 1;
            }
        });
         
        // initialization
        for (ListNode n : lists) {
            if (n==null)
                continue;
                 
            queue.add(n);
        }
         
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
         
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            current.next = n;
            current = n;
            if (n.next!=null)
                queue.add(n.next);
        }
         
        return fakeHead.next;
    }
}


//another
public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null; 
        int last = lists.size() - 1;
        while(last > 0) {
            int cur = 0;
            while(cur < last) {
                lists.set(cur, mergeTwoLists(lists.get(cur++), 
                            lists.get(last--)));
            }
        }
        return lists.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }