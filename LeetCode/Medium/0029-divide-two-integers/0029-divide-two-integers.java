class Solution {
    public int divide(int dividend, int divisor) {
        int count=0;
        int toAdd;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
            toAdd=-1;
        }
        else {
            toAdd=1;
        }
        if(dividend>=Integer.MAX_VALUE) {
            if(divisor==1) {
                return Integer.MAX_VALUE;
            }
            else if(divisor==-1) {
                return Integer.MIN_VALUE;
            }
        }
        else if(dividend<=Integer.MIN_VALUE) {
            if(divisor==1) {
                return Integer.MIN_VALUE;
            }
            else if(divisor==-1) {
                return Integer.MAX_VALUE;
            }
        }
        while(Math.abs(dividend)>=Math.abs(divisor)) {
            dividend=Math.abs(dividend)-Math.abs(divisor);
            count=count+toAdd;
        }
        return count;
    }
}