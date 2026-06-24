class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // int count=0, mini=Integer.MIN_VALUE;
        // for(int num : nums) {
        //     if(num<0) {
        //         count++;
        //         mini=Math.max(num, mini);
        //     }
        // }
        // if(count==nums.length) {
        //     return mini;
        // }
        int sum=nums[0];
        int max=nums[0], positive=nums[0];
        for(int i=1;i<nums.length;i++) {
            sum+=nums[i];
            max=Math.max(nums[i], max+nums[i]);
            positive=Math.max(positive, max);
        }
        int min=nums[0],  negative=nums[0];
        for(int i=1;i<nums.length;i++) {
            min=Math.min(nums[i], min+nums[i]);
            negative=Math.min(negative, min);
        }
        return sum!=negative?Math.max(positive, sum-negative):positive;
    }
}