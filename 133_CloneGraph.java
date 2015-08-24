// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


// OJ's undirected graph serialization:
// Nodes are labeled uniquely.

// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.

// The graph has a total of three nodes, and therefore contains three parts as separated by #.

// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:

//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/



/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        List<UndirectedGraphNode> list = new ArrayList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        list.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        //clone nodes;
        int start = 0;
        while(start < list.size()) {
            UndirectedGraphNode head = list.get(start);
            start++;
            for(int i=0; i<head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    list.add(neighbor);
                }
            }
        }
        //clone neighbor;
        for(int i=0; i<list.size(); i++) {
            UndirectedGraphNode newNode = map.get(list.get(i));
            for(int j = 0; j<list.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(list.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}