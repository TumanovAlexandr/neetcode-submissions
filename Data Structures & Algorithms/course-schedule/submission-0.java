
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int c = 0; c < numCourses; c++) {
            graph.put(c, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        Set<Integer> seen = new HashSet<>();

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(graph, seen, c)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> seen, int crs) {
        if (seen.contains(crs)) {
            return false;
        }

        if (graph.get(crs).isEmpty()) {
            return true;
        }

        seen.add(crs);
        for (int neighbor : graph.get(crs)) {
            if (!dfs(graph, seen, neighbor)) {
                return false;
            }
        }
        seen.remove(crs);
        graph.put(crs, new ArrayList<>());
        return true;
    }
}
/**
Questions:
1 <= numCourses <= 1000
0 <= prerequisites.length <= 1000
prerequisites[i].length == 2
0 <= a[i], b[i] < numCourses
All prerequisite pairs are unique.

[[1,0],[2,1]] numCouses = 3

0 -> 1 -> 2
^i
[0:[],1:[],2:[]]

seen = []
numCourses = 3

TC: O(V + E), SC: O(V + E)
*/