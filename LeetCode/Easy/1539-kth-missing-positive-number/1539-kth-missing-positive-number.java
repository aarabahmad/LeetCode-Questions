class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int res=n+k;
        int start=0, end=n-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]>mid+k) {
                res=mid+k;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return res;   
    }
}