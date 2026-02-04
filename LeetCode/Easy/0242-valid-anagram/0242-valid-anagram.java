class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        char[] alpha=new char[26];
        for(char ch : s.toCharArray()) {
            alpha[ch-'a']++;
        }
        for(char ch : t.toCharArray()) {
            alpha[ch-'a']--;
        }
        int count=0;
        for(int i=0;i<alpha.length;i++) {
            if(alpha[i]!=0) {
                return false;
            }
        }
        return true;
    }
}