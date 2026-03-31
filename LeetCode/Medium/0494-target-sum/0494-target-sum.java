class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        findWays(nums, target, 0, 0);
        return count;
    }
    public void findWays(int[] nums, int target, int sum, int index) {
        if(index==nums.length) {
            if(sum==target) {
                count++;
            }
            return;
        }
        findWays(nums, target, sum+nums[index], index+1);
        findWays(nums, target, sum-nums[index], index+1);
    }
}