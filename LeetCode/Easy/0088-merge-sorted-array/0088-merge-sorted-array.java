class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) {
            return;
        }
        else if(m==0) {
            for(int i=0;i<n;i++) {
                nums1[i]=nums2[i];
            }
            return;
        }
        else {
            for(int i=m;i<m+n;i++) {
                nums1[i]=nums2[i-m];
            }
            Arrays.sort(nums1);
        }
    }
}