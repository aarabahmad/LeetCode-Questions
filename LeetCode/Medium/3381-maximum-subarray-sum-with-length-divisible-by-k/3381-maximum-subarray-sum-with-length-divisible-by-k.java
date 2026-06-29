class Solution {
    public long kadane(List<Long> nums) {
        long ans=Long.MIN_VALUE;
        long currSum=0;
        for(long num : nums) {
            currSum+=num;
            ans=Math.max(ans, currSum);
            if(currSum<0) {
                currSum=0;
            }
        }
        return ans;
    }
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        if(k==1) {
            List<Long> toPass=new ArrayList<>();
            for(int num : nums) {
                toPass.add((long)num);
            }
            return kadane(toPass);
        }
        long prefix[]=new long[nums.length];
        prefix[0]=(long)nums[0];
        for(int i=1;i<nums.length;i++) {
            prefix[i]=prefix[i-1]+(long)nums[i];
        }
        List<List<Long>> newArr=new ArrayList<>();
        for(int i=0;i<k;i++) {
            List<Long> row=new ArrayList<>();
            for(int j=k-1+i;j<n;j+=k) {
                long add=prefix[j], sub=0;
                if(i>0 || j>k-1+i) {
                    sub=prefix[j-k];
                }
                row.add((add-sub));
            }
            newArr.add(row);
        }
        long ans=Long.MIN_VALUE;
        for(List<Long> arr : newArr) {
            ans=Math.max(ans, kadane(arr));
        }
        return ans;
    }
}