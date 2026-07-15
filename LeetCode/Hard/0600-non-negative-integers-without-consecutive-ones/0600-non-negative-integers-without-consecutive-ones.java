class Solution {
    String num;
    HashMap<String, Integer> dp = new HashMap<>();
    public int findIntegers(int n) {
        num = Integer.toBinaryString(n);
        return solve(0, true, false);
    }
    private int solve(int idx, boolean tight, boolean prevOne) {
        if (idx == num.length()) {
            return 1;
        }
        String key = idx + "," + tight + "," + prevOne;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ub = tight ? (num.charAt(idx) - '0') : 1;
        int res = 0;
        for (int digit = 0; digit <= ub; digit++) {
            if (digit == 1 && prevOne) {
                continue;
            }
            res += solve(idx + 1, tight && (digit == ub), digit == 1);
        }
        dp.put(key, res);
        return res;
    }
}