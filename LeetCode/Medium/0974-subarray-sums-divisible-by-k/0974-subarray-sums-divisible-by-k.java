class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        int prefixSum=0;
        int[] remainder=new int[k];
        remainder[0]=1;
        for(int num : nums) {
            prefixSum+=num;
            int required=((prefixSum%k)+k)%k;
            if(remainder[required]!=0) {
                count+=remainder[required];
            }
            remainder[required]++;
        }
        return count;
    }
}