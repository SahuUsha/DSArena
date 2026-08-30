class Solution {
    public int divide(int n, int b1) {
        // code here
        long ans =0;
        
        
        boolean sign =true;
        if(n<0 && b1>=0) sign= false;
        if(n>=0 && b1<0) sign = false;
        long a = Math.abs(n);
        long b = Math.abs(b1);
        
        while(a>=b){
            
           int  cnt =0;
           while(a>=(b<<cnt+1)){
               cnt++;
           }
           ans += 1L<<cnt;
            a = a - (b<<(cnt));
        }
        
        if(!sign){
            ans = -ans;
            return (int) ans;
        }
        
        return (int)ans;
    }
}