class Solution {
    public double findPow(double x, long n) {
        if(n==0) {
            return 1.0;
        }
        double half=findPow(x, n/2);
        double res=half*half;
        if(n%2!=0) {
            res=res*x;
        }
        return res;
    }
    public double myPow(double x, int n) {
        double res=findPow(x, Math.abs(n));
        if(n<0) {
            return 1/res;
        }
        return res;
    }
}