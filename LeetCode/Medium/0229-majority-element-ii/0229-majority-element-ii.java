class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> freq=new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Integer> majority=new ArrayList<>();
        Map<Integer, Integer> added=new HashMap<>();
        for(int num : nums) {
            if(freq.get(num)>n/3 && !added.containsKey(num)) {
                majority.add(num);
                added.put(num, 0);
            }
        }
        return majority;
    }
}