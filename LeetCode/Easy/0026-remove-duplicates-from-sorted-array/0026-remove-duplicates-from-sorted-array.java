class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1, count=1;
        for(int i=1;i<nums.length;) {
            if(nums[i]!=nums[i-1]) {
                nums[index++]=nums[i];
                count++;
            }
            i++;
        }
        return count;
    }
}