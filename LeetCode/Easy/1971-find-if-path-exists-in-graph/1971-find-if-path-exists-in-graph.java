class Solution {

    Queue<Integer> queue=new LinkedList<>();
    boolean[] visited;

    public boolean bfs(List<List<Integer>> adj, int source, int destination) {
        visited[source]=true;
        queue.offer(source);
        while(!queue.isEmpty()) {
            int node=queue.poll();
            if(node==destination && visited[destination]) {
                return true;
            }
            for(int neighbours : adj.get(node)) {
                if(!visited[neighbours]) {
                    visited[neighbours]=true;
                    queue.offer(neighbours);
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean res=bfs(adj, source, destination);
        return res;
    }
}