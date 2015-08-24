// Sort a linked list using insertion sort.
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null) {
            ListNode temp = head.next;
            while(cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = temp;
            cur = dummy;
        }
        return dummy.next;
    }
}