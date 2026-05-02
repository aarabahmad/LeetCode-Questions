class Solution {
    public int minEatingSpeed(int[] piles, int hour) {
        int start=1, end=0;
        for(int i : piles) {
            end=Math.max(end, i);
        }
        int result=0;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(canEatAll(piles, mid, hour)) {
                result=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return result;
    }

    public boolean canEatAll(int[] piles, int rate, int hours) {
        int hour=0;
        for(int i=0;i<piles.length;i++) {
            hour+=(piles[i]/rate);
            if(piles[i]%rate!=0) {
                hour++;
            }
            if(hour>hours) {
                return false;
            }
        }
        return true;
    }
}