class Solution {
    public int gcdOfOddEvenSums(int n) {
        int count=0;
        int sumOdd=n*n, sumEven=n*(n+1);
        while(sumOdd%sumEven!=0) {
            sumOdd=sumOdd%sumEven;
            int temp=sumOdd;
            sumOdd=sumEven;
            sumEven=temp;
        }
        return sumEven;
    }
}