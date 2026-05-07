class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int ans=-1;
        if(target>nums[end]) {
            return end+1;
        }
        else {
            while(start<=end) {
                int mid=start+(end-start)/2;
                if(nums[mid]>=target) {
                    ans=mid;
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
            return ans;
        }
    }
}