class Solution {

    public int bfs(int n, List<List<int[]>> adjacency) {
        int routes = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] neighbours : adjacency.get(curr)) {
                int destination = neighbours[0];
                int needsReversal = neighbours[1];
                if (!visited[destination]) {
                    routes = routes + needsReversal;
                    visited[destination] = true;
                    queue.offer(destination);
                }
            }
        }
        return routes;
    }

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int source = connection[0];
            int destination = connection[1];
            adjacency.get(source).add(new int[] { destination, 1 });
            adjacency.get(destination).add(new int[] { source, 0 });
        }
        return bfs(n, adjacency);
    }
}