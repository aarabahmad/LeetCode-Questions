// class Solution {
//     int MOD=(int)1e9+7;
//     public int strStr(String haystack, String needle) {
//         int n=haystack.length();
//         int m=needle.length();
//         int start=0;
//         int end=needle.length()-1;
//         if(haystack.length()==needle.length()) {
//             if(haystack.equals(needle)) {
//                 return 0;
//             }
//             else {
//                 return -1;
//             }
//         }
//         int biggestPower=1;
//         for(int i=0;i<needle.length()-1;i++) {
//             biggestPower=(biggestPower*26)%MOD; 
//         }
//         // System.out.println(biggestPower);
//         int copy=biggestPower;
//         int patternHash=0;
//         for(char ch : needle.toCharArray()) {
//             patternHash=patternHash+((ch-'a'+1)*(copy))%MOD;
//             // System.out.println(patternHash);
//             copy/=26;
//         }
//         copy=biggestPower;
//         return patternHash;
//     }
// }
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        if (m > n) {
            return -1;
        }
        long MOD = (long)(1e9+7);
        long BASE = 26;
        long patternHash = 0;
        long windowHash = 0;
        long highestPower = 1;
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % MOD;
        }
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + needle.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + haystack.charAt(i)) % MOD;
        }
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == windowHash) {
                int j = 0;
                while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    return i;
                }
            }
            if (i < n - m) {
                windowHash = (windowHash - haystack.charAt(i) * highestPower) % MOD;
                if (windowHash < 0) {
                    windowHash += MOD;
                }
                windowHash = (windowHash * BASE + haystack.charAt(i + m)) % MOD;
            }
        }
        return -1;
    }
}