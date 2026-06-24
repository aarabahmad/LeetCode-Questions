class Solution {

    public void swap(int a, int b) {
        int temp=a;
        a=b;
        b=temp;
    }

    public void reverse(int[] nums) {
        int start=0, end=nums.length-1;
        while(start<end) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                // swap(matrix[i][j], matrix[j][i]);
            }
        }
        for(int[] row : matrix) {
            reverse(row);
        }
    }
}