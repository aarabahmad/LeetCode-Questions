class Solution {
    
    public void buildSeive(boolean[] seive, int num) {
        Arrays.fill(seive, true);
        seive[0]=false;
        seive[1]=false;
        for(int i=2;i*i<=num;i++) {
            if(seive[i]) {
                for(int j=i*i;j<=num;j+=i) {
                    seive[j]=false;
                }
            }
        }
    }

    public int countPrimes(int n) {
        boolean[] seive=new boolean[n+2];
        buildSeive(seive, n);
        int count=0;
        for(int i=0;i<n;i++) {
            if(seive[i]) {
                count++;
            }
        }
        return count;
    }
}