class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1, end=Integer.MIN_VALUE, res=0;
        for(int i : piles) {
            end=Math.max(i, end);
        }
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(canEatAll(piles, h, mid)) {
                res=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }

    public static boolean canEatAll(int[] piles, int hours, int rate) {
        int hour=0;
        for(int i : piles) {
            hour+=(i/rate);
            if(i%rate!=0) {
                hour++;
            }
            if(hour>hours) {
                return false;
            }
        }
        return true;
    }
}