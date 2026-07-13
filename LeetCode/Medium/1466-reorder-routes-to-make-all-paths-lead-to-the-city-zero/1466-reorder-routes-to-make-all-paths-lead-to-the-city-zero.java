class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> undirected=new ArrayList<>();
        List<List<Integer>> directed=new ArrayList<>();
        for(int i=0;i<n;i++) {
            undirected.add(new ArrayList<>());
            directed.add(new ArrayList<>());
        }
        for(int[] connection : connections) {
            undirected.get(connection[0]).add(connection[1]);
            undirected.get(connection[1]).add(connection[0]);
            directed.get(connection[0]).add(connection[1]);
        }
        // System.out.println("Undirected: \n"+undirected);
        // System.out.println("Directed: \n"+directed);
        int res=0;
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        visited[0]=true;
        while(!queue.isEmpty()) {
            int node=queue.poll();
            for(int neighbours : undirected.get(node)) {
                if(!visited[neighbours] && !directed.get(neighbours).contains(node)) {
                    res++;
                }
                if(!visited[neighbours]) {
                    visited[neighbours]=true;
                    queue.offer(neighbours);
                }
                // System.out.println("Neighbour: "+neighbours+", Res: "+res);
            }
        }
        return res;
    }
}