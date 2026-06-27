class Solution {
    public int fib(int n) {
        int[] fibonacci=new int[n+1];
        fibonacci[0]=0;
        if(n==0) {
            return fibonacci[n];
        }
        fibonacci[1]=1;
        if(n==1) {
            return fibonacci[n];
        }
        for(int i=2;i<=n;i++) {
            fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
        }
        return fibonacci[n];
    }
}