class Solution {
    public boolean isPalindrome(int n) {
        if(n<0) {
            return false;
        }
        int reverse=0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int copy=n;
        while(copy!=0) {
            if(reverse>max/10 || reverse<min/10) {
                return false;
            }
            reverse=(reverse*10)+(copy%10);
            copy=copy/10;
        }
        return reverse==n;
    }
}