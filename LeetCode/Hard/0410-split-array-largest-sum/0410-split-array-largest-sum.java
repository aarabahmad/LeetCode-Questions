class Solution {
    public int splitArray(int[] nums, int k) {
        int start=nums[0], end=0;
        for(int num : nums) {
            start=Math.max(num, start);
            end+=num;
        }
        int res=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(canSplit(nums, mid, k)) {
                res=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }

    public boolean canSplit(int[] nums, int subSum, int subarrays) {
        int count = 1;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (currentSum > subSum) {
                count++;
                currentSum = num;
                if (count > subarrays) {
                    return false;
                }
            }
        }
        return true;
    }
}