class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++) {
            for(String str : wordDict) {
                int size=str.length();
                if(size<=i) {
                    // System.out.println(s.substring(i-size, i));
                    if(s.substring(i-size, i).equals(str) && dp[i-size]==true) {
                        System.out.println(s.substring(i-size, i));
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}