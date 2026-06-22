class Solution {
    public void seiveRange(boolean[] seive, int n) {
        Arrays.fill(seive, true);
        for(int i=2;i*i<=n;i++) {
            if(seive[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    seive[j]=false;
                }
            }
        }
    }
    public int countPrimes(int n) {
        int prime=0;
        boolean seive[]=new boolean[n+1];
        seiveRange(seive, n);
        for(int i=2;i<n;i++) {
            if(seive[i]) {
                prime++;
            }
        }
        return prime;

    }
}