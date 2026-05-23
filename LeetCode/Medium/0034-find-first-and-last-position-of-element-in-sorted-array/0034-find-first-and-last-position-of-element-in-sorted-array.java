class Solution {
    public int firstPos(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int result=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(nums[mid]>=target) {
                if(nums[mid]==target) {
                    result=mid;
                }
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return result;
    }
    public int lastPos(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int result=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(nums[mid]<=target) {
                if(nums[mid]==target) {
                    result=mid;
                }
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int first=firstPos(nums, target);
        int last=lastPos(nums, target);
        return new int[]{first, last};
    }
}