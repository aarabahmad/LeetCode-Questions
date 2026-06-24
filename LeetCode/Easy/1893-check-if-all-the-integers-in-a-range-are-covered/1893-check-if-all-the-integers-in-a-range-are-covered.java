class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] nums=new int[52];
        for(int[] arr : ranges) {
            nums[arr[0]]++;
            nums[arr[1]+1]--;
        }
        for(int i=1;i<nums.length;i++) {
            nums[i]+=nums[i-1];
        }
        for(int i=left;i<=right;i++) {
            if(nums[i]==0) {
                return false;
            }
        }
        return true;
    }
}