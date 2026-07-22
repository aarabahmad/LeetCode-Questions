class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        visited[source]=true;
        queue.offer(source);
        while(!queue.isEmpty()) {
            int node=queue.poll();
            for(int neighbours : adj.get(node)) {
                if(!visited[neighbours]) {
                    visited[neighbours]=true;
                    queue.offer(neighbours);
                }
            }
        }
        return visited[destination];
    }
}