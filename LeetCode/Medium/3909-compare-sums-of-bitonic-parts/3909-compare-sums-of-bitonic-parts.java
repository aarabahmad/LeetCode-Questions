class Solution {
    public int compareBitonicSums(int[] nums) {
        int peak=0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                peak=i;
                break;
            }
        }
        long incSum=0, decSum=0;
        for(int i=0;i<=peak;i++) {
            incSum+=nums[i];
        }
        for(int i=peak;i<nums.length;i++) {
            decSum+=nums[i];
        }
        if(incSum>decSum) {
            return 0;
        }
        else if(decSum>incSum) {
            return 1;
        }
        return -1;
    }
}