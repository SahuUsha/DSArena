class Solution {
    public int nthRoot(int n, int m) {
        return NthRoot(n,m);
        // code here
       
        
    }
    public int NthRoot(int n , int m){
        if(m==0){
            return 0;
        }
        
        
        int low =1;
        int high = m;
        
        while(low<=high){
            int mid = (low + high)/2 ;
            int midN = provideroot(mid,n);
            if(midN==m){
                return mid;
            }
            else if(midN>mid){
                high= mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public int provideroot(int mid, int n){
         long ans = 1;
        while(n>0){
            if(n%2==1){
                ans = ans*mid;
                n = n-1;
                
            }else{
                mid = mid*mid;
                n = n/2;
            }
        }
        return (int)ans;
    }
    
}