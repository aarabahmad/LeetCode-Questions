class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        int prefixSum=0;
        Map<Integer, Integer> remainder=new HashMap<>();
        remainder.put(0, 1);
        for(int num : nums) {
            prefixSum+=num;
            int required=((prefixSum%k)+k)%k;
            if(remainder.containsKey(required)) {
                count+=remainder.get(required);
            }
            remainder.put(required, remainder.getOrDefault(required, 0)+1);
        }
        // System.out.println()
        return count;
    }
}