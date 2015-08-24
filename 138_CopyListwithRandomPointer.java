// A linked list is given such that each node contains an additional random
//  pointer which could point to any node in the list or null.

// Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode res = head;
        while(res != null) {
            map.put(res, new RandomListNode(res.label));
            res = res.next;
        }
        
        res = head;
        while(res != null) {
            map.get(res).next = map.get(res.next);
            res = res.next;
        }
        
        res = head;
        while(res != null) {
            map.get(res).random = map.get(res.random);
            res = res.next;
        }
        return map.get(head);
    }
}
//check
 public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
         
        RandomListNode fakeTargetHead = new RandomListNode(0);
         
        RandomListNode src = head;
        RandomListNode target = fakeTargetHead;
        while (src!=null) {
            RandomListNode node = new RandomListNode(src.label);
            map.put(src, node);
             
            target.next = node;
             
            src = src.next;
            target = target.next;
        }
         
        src = head;
        while (src!=null) {
            if (null!=src.random) {
                RandomListNode node = map.get(src);
                RandomListNode to = map.get(src.random);
                 
                node.random = to;
            }
             
            src = src.next;
        }
         
        return fakeTargetHead.next;
    }
}