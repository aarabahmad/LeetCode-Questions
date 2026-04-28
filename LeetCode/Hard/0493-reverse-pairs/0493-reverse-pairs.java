class Solution {

    public int mergeSort(int[] nums, int left, int right) {
        int pairs=0;
        if(left<right) {
            int mid=left+(right-left)/2;
            pairs+=mergeSort(nums, left, mid);
            pairs+=mergeSort(nums, mid+1, right);
            pairs+=countPairs(nums, left, mid, right);
            merge(nums, left, mid, right);
        }
        return pairs;
    }

    public int countPairs(int[] nums,int left, int mid, int right) {
        int j=mid+1;
        int pairs=0;
        for(int i=left;i<=mid;i++) {
            while(j<=right && nums[i]>2L*nums[j]) {
                j++;
            }
            pairs+=(j-(mid+1));
        }
        return pairs;
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i=left, j=mid+1, k=0;
        int temp[]=new int[right-left+1];
        while(i<=mid && j<=right) {
            if(nums[i]<=nums[j]) {
                temp[k++]=nums[i++];
            }
            else {
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid) {
            temp[k++]=nums[i++];
        }
        while(j<=right) {
            temp[k++]=nums[j++];
        }
        for (int index = 0; index < temp.length; index++) {
            nums[left + index] = temp[index];
        }
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}