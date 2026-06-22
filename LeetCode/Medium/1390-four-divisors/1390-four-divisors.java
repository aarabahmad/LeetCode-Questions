class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++) {
            int count=0, sum=0;
            for(int j=1;j*j<=nums[i];j++) {
                if(nums[i]%j==0) {
                    sum+=j;
                    sum+=(nums[i]/j);
                    if(j==nums[i]/j) {
                        count++;
                    }
                    else {
                        count+=2;
                    }
                }
            }
            if(count==4) {
                totalSum+=sum;
            }
        }
        return totalSum;
    }
}