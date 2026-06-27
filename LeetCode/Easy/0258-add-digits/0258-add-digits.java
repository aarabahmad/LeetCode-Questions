class Solution {
    public int addDigits(int n) {
        if(n==0 || n%9!=0) {
            return n%9;
        }
        return 9;
    }
}