class Solution {
    int[] parent;
    int[] size;
    public void init(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    public boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA==parentB) return false;

        if(size[parentA]>=size[parentB]){
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }else{
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
        return true;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] edge1 = new int[2];
        int[] edge2 = new int[2];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(parent[v]!=0){
                edge1[0] = parent[v];
                edge1[1] = v;
                edge2[0] = u;
                edge2[1] = v;
                break;
            }else{
                parent[v] = u;
            }
        }

        if(edge2[1]!=0){
            init(n+1);
            for(int[] e : edges){
                int u = e[0];
                int v = e[1];
                if(u==edge2[0] && v==edge2[1]) {
                    continue;
                }
                if(!union(u, v)){ 
                    return edge1; 
                }
            }
            return edge2; 
        }
        init(n+1);
        int[] res = new int[2];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(!union(u, v)){
                res[0] = u;
                res[1] = v;
            }
        }
        return res;
    }
}