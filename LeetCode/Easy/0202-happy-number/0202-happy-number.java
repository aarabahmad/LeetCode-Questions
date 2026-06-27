class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7) {
            return true;
        }
        if(n<10) {
            return false;
        }
        int sum=Integer.MAX_VALUE;;
        while(sum>9) {
            sum=0;
            while(n!=0) {
                int digit=n%10;
                sum=sum+(digit*digit);
                n/=10;
            }
            n=sum;
        }
        return n==1 || n==7;
    }
}