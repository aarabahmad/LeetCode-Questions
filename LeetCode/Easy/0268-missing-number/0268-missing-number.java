class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int expSum=(n*(n+1))/2;
        for(int i : nums) {
            expSum-=i;
        }
        return expSum;
    }
}