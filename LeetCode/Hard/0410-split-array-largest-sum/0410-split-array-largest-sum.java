class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0, end=0;
        for(int num : nums) {
            start=Math.max(num, start);
            end+=num;
        }
        while(start<=end) {
            int mid=start+(end-start)/2;
            if (canSplit(nums, mid, k)) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return end+1;
    }

    public boolean canSplit(int[] nums, int sum, int subArrays) {
        int count=0;
        for(int i=0;i<nums.length;i++) {
            int subArraySum=0;
            while(i<nums.length && subArraySum+nums[i]<=sum) {
                subArraySum+=nums[i];
                i++;
            }
            if(subArraySum<=sum) {
                count++;
                i--;
            }
        }
        return count<=subArrays;
    }
}