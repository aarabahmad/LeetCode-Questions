class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1, end=1, res=0;
        for(int pile : piles) {
            end=Math.max(pile, end);
        }
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(possible(piles, mid, h)) {
                res=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }

    public boolean possible(int[] piles, int rate, int hour) {
        int time=0;
        for(int pile : piles) {
            time+=(pile/rate);
            if(pile%rate!=0) {
                time++;
            }
            if(time>hour) {
                return false;
            }
        }
        return true;
    }
}