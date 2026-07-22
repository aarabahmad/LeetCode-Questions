class Solution {

    public boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, int source) {
        visited[source] = true;
        pathVisited[source]=true;
        for (int edges : graph[source]) {
            if (!visited[edges]) {
                if (dfs(graph, visited, pathVisited, edges)) {
                    return true;
                }
            } else if (pathVisited[edges]) {
                return true;
            }
        }
        pathVisited[source] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
            if (!visited[i]) {
                boolean cycle=dfs(graph, visited, pathVisited, i);
                // System.out.println(i+"->"+cycle);
                if (!cycle) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}