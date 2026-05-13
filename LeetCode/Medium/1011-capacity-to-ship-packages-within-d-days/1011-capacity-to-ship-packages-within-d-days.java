class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start=1, end=0;
        for(int  i : weights) {
            start=Math.max(i, start);
            end+=i;
        }
        int res=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(canPack(weights, days, mid)) {
                res=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }

        }
        return res;
    }

    public boolean canPack(int[] weights, int days, int capacity) {
        int day=0;
        int count=0;
        for(int i=0;i<weights.length;i++) {
            int sum=0;
            while(i<weights.length && sum+weights[i]<=capacity) {
                sum+=weights[i];
                i++;
                count++;
            }
            if(sum!=0 && sum<=capacity) {
                day++;
                i--;
            }
        }
        if(day<=days && count==weights.length) {
            return true;
        }
        return false;
    }
}