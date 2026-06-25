class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start=1, end=position[position.length-1]-position[0];
        int res=-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(canAssign(position, mid, m)) {
                res=mid;
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return res;
    }

    public boolean canAssign(int[] position, int distance, int balls) {
        int prevAssigned=position[0];
        int ballPlaced=1;
        for(int i=1;i<position.length;i++) {
            if(position[i]-prevAssigned>=distance) {
                ballPlaced++;
                prevAssigned=position[i];
                if(ballPlaced>=balls) {
                    return true;
                }
            }
        }
        return false;
    }
}