class Solution {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> freq=new HashMap<>();
        for(char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
            if(freq.get(ch)==2) {
                return ch;
            }
        }
        return 'a';
    }
}