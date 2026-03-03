class Solution {
public:
     int  MOD=1e9+7;
    
    long long p(long long a, long long b){
        if(b==0){
            return 1;
        }

        long long half=p(a,b/2);
        long long ans=(half*half)%MOD;

        if(b%2==1){
            ans=(ans*a)%MOD;
        }
        return ans;
    }
    int countGoodNumbers(long long n) {
        return p(5,(n+1)/2)* p(4,n/2)%MOD;

        
    }
};