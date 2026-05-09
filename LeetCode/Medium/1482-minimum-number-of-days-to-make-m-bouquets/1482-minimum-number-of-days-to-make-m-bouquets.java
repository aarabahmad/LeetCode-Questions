class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((m*k)>bloomDay.length) {
            return -1;
        }
        int start=Integer.MAX_VALUE, end=Integer.MIN_VALUE, res=-1;
        for(int i : bloomDay) {
            start=Math.min(i, start);
            end=Math.max(i, end);
        }
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(canMakeBouquets(bloomDay, m, k, mid)) {
                res=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }

    public boolean canMakeBouquets(int[] bloomDay, int bouquets, int adjacent, int days) {
        int total=0;
        for(int i=0;i<bloomDay.length;i++) {
            int count=0;
            while(i<bloomDay.length && count<adjacent && bloomDay[i]<=days) {
                count++;
                i++;
            }
            if(count==adjacent) {
                total++;
                i--;
            }
            if(total>=bouquets) {
                return true;
            }
        }
        return false;
    }
}