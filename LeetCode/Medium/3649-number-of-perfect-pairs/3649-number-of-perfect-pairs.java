class Solution {

    public long upperBound(int[] nums, int target) {
        long start=0, end=nums.length-1;
        long result=-1;
        if(target>=nums[(int)end]) {
            return end+1;
        }
        while(start<=end) {
            long mid=start+(end-start)/2;
            if(nums[(int)mid]>target) {
                result=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return result;
    }

    public long perfectPairs(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long res=0;
        for(int i=0;i<nums.length;i++) {
            long ub=upperBound(nums, 2*nums[i])-1;
            res+=(ub-i);
        }
        return res;
    }
}