class Solution {
    public int removeDuplicates(int[] arr) {
        int count=1, index=1;
        for(int i=1;i<arr.length;) {
            if(i<arr.length && arr[i]==arr[i-1]) {
                i++;
            }
            else {
                if(i<arr.length) {
                    arr[index++]=arr[i++];
                    count++;
                }
            }
        }
        return count;
    }
}