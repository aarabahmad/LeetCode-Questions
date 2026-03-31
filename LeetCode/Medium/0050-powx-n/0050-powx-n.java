class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(n<0) {
            return 1/findPow(x, -N);
        }
        else {
            return findPow(x, N);
        }
    }

    public double findPow(double x, long n) {
        if(n==0) {
            return 1.0;
        }
        double half=findPow(x, n/2);
        double res=half*half;
        if(n%2==1) {
            res=res*x;
        }
        return res;
    }
}