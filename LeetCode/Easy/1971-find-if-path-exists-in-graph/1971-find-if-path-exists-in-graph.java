class Solution {

    boolean[] visited;
    boolean res=false;

    public boolean dfs(List<List<Integer>> adj, int source, int destination) {
        visited[source]=true;
        if(visited[destination]) {
            return true;
        }
        for(int neighbours : adj.get(source)) {
            if(!visited[neighbours]) {
                res=dfs(adj, neighbours, destination);
            }
        }
        return res;
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
        boolean res=dfs(adj, source, destination);
        System.out.println(Arrays.toString(visited));
        return res;
    }
}