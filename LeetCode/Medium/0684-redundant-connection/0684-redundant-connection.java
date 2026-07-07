class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for(int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            if(union(edge[0], edge[1])) {
                return edge; 
            }
        }
        return new int[0];
    }

    private int find(int x){
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) {
            return true;
        }
        parent[rootX] = rootY;
        return false;
    }
}