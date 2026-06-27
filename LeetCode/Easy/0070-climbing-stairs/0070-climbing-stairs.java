class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return climbStairs(n, map);
    }

    private int climbStairs(int n, Map<Integer, Integer> map) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, climbStairs(n-1, map)+climbStairs(n-2, map));
        return map.get(n);
    }
}