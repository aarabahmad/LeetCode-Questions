class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1=new LinkedHashMap<>();
        for(int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }
        Map<Integer, Integer> map2=new LinkedHashMap<>();
        for(int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey())) {
                return entry.getKey();
            }
        }
        return -1;
    }
}