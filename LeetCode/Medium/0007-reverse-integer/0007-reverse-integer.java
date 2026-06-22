class Solution {
    public int reverse(int x) {
        int sign=(x>=0)?1:-1;
        long min=Integer.MIN_VALUE;
        long max=Integer.MAX_VALUE;
        int rev=0;
        while(x!=0) {
            if(((long)rev*10)>max || (long)((long)rev*10)<min) {
                return 0;
            }
            rev=(rev*10)+(x%10);
            x/=10;
        }
        return rev;
    }
}