class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        for(int i : nums) {
            if(i==0) {
                count++;
            }
        }
        if(count==nums.length) {
            return 0;
        }
        count=1;
        int maxCount=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]==nums[i] && nums[i]==1) {
                count++;
                maxCount=Math.max(count, maxCount);
            }
            else {
                count=1;
            }
        }
        return maxCount;
    }
}