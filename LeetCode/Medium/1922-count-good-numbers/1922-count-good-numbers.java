class Solution {
    long MOD=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long res=(findPow(5, even)*findPow(4, odd))%MOD;
        return (int)res;
    }

    public long findPow(long a, long b) {
        if(b==0) {
            return 1;
        }
        long half=findPow(a, b/2);
        long res=(half*half)%MOD;
        if(b%2==1) {
            res=(res*a)%MOD;
        }
        return res;
    }
}