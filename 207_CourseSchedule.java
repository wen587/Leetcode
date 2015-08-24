// There are a total of n courses you have to take, labeled from 0 to n - 1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// For example:

// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

// 2, [[1,0],[0,1]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

// click to show more hints.

// Hints:
// This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
// Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
// Topological sort could also be done via BFS.


//BFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int cnt = numCourses;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
            
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i : map.get(current)) {
                if(--indegree[i] == 0) queue.offer(i);
            }
            cnt--;
        }
        return cnt == 0;
        
    }
}

//dfs   hashmap tle了。。。why
public class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++)
                graph[i] = new ArrayList();

            boolean[] visited = new boolean[numCourses];
            for(int i=0; i<prerequisites.length;i++){
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
            }

            for(int i=0; i<numCourses; i++){
                if(!dfs(graph,visited,i))
                    return false;
            }
            return true;
        }

        private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
            if(visited[course])
                return false;
            else
                visited[course] = true;;

            for(int i=0; i<graph[course].size();i++){
                if(!dfs(graph,visited,(int)graph[course].get(i)))
                    return false;
            }
            visited[course] = false;
            return true;
        }
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    //     for(int i=0; i<numCourses; i++) {
    //         map.put(i, new ArrayList<Integer>());
    //     }
    //     for(int i=0; i<prerequisites.length; i++) {
    //         map.get(prerequisites[i][1]).add(prerequisites[i][0]);
    //     }
    //     boolean[] visited = new boolean[numCourses];
    //     for(int i=0; i<numCourses; i++) {
    //         if(!helper(map, visited, i)) return false;
    //     }
    //     return true;
    // }
    // public boolean helper(Map<Integer, List<Integer>> map, boolean[] visited, int i) {
    //     if(visited[i]) return false;
    //     else visited[i] = true;
    //     for(int j=0; j<map.get(i).size(); j++) {
    //         if(!helper(map, visited, map.get(i).get(j))) return false;
    //     }
    //     visited[i] = false;
    //     return true;
    // }
}