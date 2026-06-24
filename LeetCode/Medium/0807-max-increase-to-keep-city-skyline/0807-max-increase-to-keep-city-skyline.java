class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int[] rowMax=new int[n];
        int[] colMax=new int[n];
        for(int i=0;i<n;i++) {
            int rMax=0, cMax=0;
            for(int j=0;j<n;j++) {
                rMax=Math.max(rMax, grid[i][j]);
                cMax=Math.max(cMax, grid[j][i]);
            }
            rowMax[i]=rMax;
            colMax[i]=cMax;
        }
        int toAdd=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int add=Math.min(rowMax[i], colMax[j])-grid[i][j];
                toAdd=(add>=0)?toAdd+add:toAdd;
            }
        }
        return toAdd;
    }
}