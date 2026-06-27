class Solution {
    public int reverse(int n) {
        int sign=n>=0?1:-1;
        n=Math.abs(n);
        int reverse=0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        while(n!=0) {
            if(reverse>max/10 || reverse<min/10) {
                return 0;
            }
            reverse=(reverse*10)+(n%10);
            n=n/10;
        }
        return sign*reverse;
    }
}