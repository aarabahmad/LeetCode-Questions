class Solution {
    public int fib(int n) {
        int first=0, second=1;
        if(n==0) {
            return first;
        }
        else if(n==1) {
            return second;
        }
        else {
            int count=1;
            while(count<=n) {
                int third=first+second;
                count++;
                if(count==n) {
                    return third;
                }
                first=second;
                second=third;
            }
        }
        return -1;
    }
}