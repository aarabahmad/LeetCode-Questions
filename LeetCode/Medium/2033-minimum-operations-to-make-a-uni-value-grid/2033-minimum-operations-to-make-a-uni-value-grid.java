class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] terms=new int[grid.length*grid[0].length];
        int index=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                terms[index++]=grid[i][j];
            }
        }
        Arrays.sort(terms);
        int midNum=terms[terms.length/2];
        int turns=0;
        for(int i=0;i<terms.length;i++) {
            int diff=Math.abs(midNum-terms[i]);
            if(diff%x==0) {
                turns+=(diff/x);
            }
            else {
                return -1;
            }
        }
        return turns;
    }
}