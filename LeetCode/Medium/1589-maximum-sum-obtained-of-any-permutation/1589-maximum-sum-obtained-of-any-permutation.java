class Solution {

    public void reverse(int[] nums) {
        int start=0, end=nums.length-1;
        while(start<end) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public void reverse(long[] nums) {
        int start=0, end=nums.length-1;
        while(start<end) {
            long temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int MOD=(int)1e9+7;
        long[] prefix=new long[nums.length+1];
        for(int[] request : requests) {
            prefix[request[0]]++;
            prefix[request[1]+1]--;
        }
        for(int i=1;i<nums.length;i++) {
            prefix[i]=prefix[i-1]+prefix[i];
        }
        Arrays.sort(nums);
        Arrays.sort(prefix);
        reverse(nums);
        reverse(prefix);
        long sum=0;
        for(int i=0;i<nums.length;i++) {
            sum+=(((long)nums[i]*prefix[i])%(MOD));
        }
        long res=sum%MOD;
        return (int)res;
    }
}