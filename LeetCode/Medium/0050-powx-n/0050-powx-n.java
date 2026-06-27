class Solution {
    public double findPow(double x, int n) {
        if(n==0) {
            return 1;
        }
        double halfPow=findPow(x, n/2);
        double res=halfPow*halfPow;
        if(n%2!=0) {
            res=res*x;
        }
        return res;
    }
    public double myPow(double x, int n) {
        int sign=n>=0?1:-1;
        double res=findPow(x, Math.abs(n));
        return (sign==1)?res:1/res;
    }
}