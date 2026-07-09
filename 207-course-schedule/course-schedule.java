import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        // Directed graph: prerequisite -> course
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (detect(i, list, visited, pathVisited)) {
                    return false;   // cycle found
                }
            }
        }

        return true;
    }

    public boolean detect(int node,
                          ArrayList<ArrayList<Integer>> list,
                          boolean[] visited,
                          boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neigh : list.get(node)) {

            if (!visited[neigh]) {
                if (detect(neigh, list, visited, pathVisited))
                    return true;
            }
            else if (pathVisited[neigh]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}