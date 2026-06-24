class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++) {
            int diff=arr[i]-arr[i-1];
            minDiff=Math.min(diff, minDiff);
        }
        List<List<Integer>> diff=new ArrayList<>();
        for(int i=1;i<arr.length;i++) {
            List<Integer> list=new ArrayList<>();
            if(arr[i]-arr[i-1]==minDiff) {
                list.add(arr[i-1]);
                list.add(arr[i]);
                diff.add(list);
            }
        }
        return diff;
    }
}