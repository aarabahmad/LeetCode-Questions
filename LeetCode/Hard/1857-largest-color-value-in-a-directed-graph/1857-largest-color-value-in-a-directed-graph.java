class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int nodeCount=colors.length();
        List<Integer>[] adjacency=new List[nodeCount];
        Arrays.setAll(adjacency, i->new ArrayList<>());
        int[] indegree=new int[nodeCount];
        for(int[] edge : edges) {
            int from=edge[0];
            int to=edge[1];
            adjacency[from].add(to);
            indegree[to]++;
        }
        Deque<Integer> queue=new ArrayDeque<>();
        int[][] dp=new int[nodeCount][26];
        for(int node=0;node<nodeCount;node++) {
            if(indegree[node]==0) {
                queue.offer(node);
                int colorIndex=colors.charAt(node)-'a';
                dp[node][colorIndex]=1;
            }
        }
        int processed=0, maxColor=1;
        while(!queue.isEmpty()) {
            int curr=queue.pollFirst();
            processed++;
            for(int neighbour : adjacency[curr]) {
                if(--indegree[neighbour]==0) {
                    queue.offer(neighbour);
                }
                int neighbourColor=colors.charAt(neighbour)-'a';
                for(int color=0;color<26;color++) {
                    int increment=(color==neighbourColor)?1:0;
                    dp[neighbour][color]=Math.max(dp[neighbour][color], dp[curr][color]+increment);
                    maxColor=Math.max(maxColor, dp[neighbour][color]);
                }
            }
        }
        return processed==nodeCount?maxColor:-1;
    }
}