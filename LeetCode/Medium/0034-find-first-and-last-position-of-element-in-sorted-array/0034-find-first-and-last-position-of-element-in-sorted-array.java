class Solution {

    public static int firstPosition(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int res=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(nums[mid]==target) {
                res=mid;
                end=mid-1;
            }
            else if(nums[mid]>target) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }

    public static int lastPosition(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int res=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(nums[mid]==target) {
                res=mid;
                start=mid+1;
            }
            else if(nums[mid]<target) {
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int first=firstPosition(nums, target);
        int second=lastPosition(nums, target);
        return new int[]{first, second};
    }
}