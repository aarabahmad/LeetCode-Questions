class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[] nums=new int[mat.length*mat[0].length];
        int index=0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                nums[index++]=mat[i][j];
            }
        }
        index=0;
        int res[][]=new int[r][c];
        if(r*c>mat.length*mat[0].length || r*c<mat.length*mat[0].length) {
            return mat;
        }
        for(int i=0;i<r;i++) {
            if(index>=nums.length) {
                break;
            }
            for(int j=0;j<c;j++) {
                res[i][j]=nums[index++];
            }
        }
        return res;
    }
}