class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++) {
            boolean res=false;
            for(int[] nums : ranges) {
                if(i>=nums[0] && i<=nums[1]) {
                    res=true;
                }
            }
            if(res==true) {
                count++;
            }
        }
        System.out.println(count);
        return count==(right-left+1);
    }
}