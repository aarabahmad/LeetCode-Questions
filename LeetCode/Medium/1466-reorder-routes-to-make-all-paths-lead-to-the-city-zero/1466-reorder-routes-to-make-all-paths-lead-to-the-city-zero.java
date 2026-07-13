class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] connection : connections) {
            adj.get(connection[0]).add(new int[]{connection[1], 1});
            adj.get(connection[1]).add(new int[]{connection[0], 0});
        }
        int res=0;
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        visited[0]=true;
        while(!queue.isEmpty()) {
            int node=queue.poll();
            for(int[] neighbours : adj.get(node)) {
                int destination=neighbours[0];
                int needReversal=neighbours[1];
                if(!visited[destination]) {
                    res+=needReversal;
                    visited[destination]=true;
                    queue.offer(destination);
                }
            }
        }
        return res;
    }
}