class Solution {
    public void moveZeroes(int[] nums) {
        int fast=0;
        for(int slow=0;slow<nums.length;slow++) {
            if(nums[slow]!=0) {
                nums[fast++]=nums[slow];
            }
        }
        while(fast<nums.length) {
            nums[fast++]=0;
        }
    }
}