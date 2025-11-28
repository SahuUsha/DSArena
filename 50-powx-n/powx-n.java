class Solution {
    public double myPow(double x, int n) {
        return provideroot(x,n);
    }

     public double provideroot(double mid, int N){
         double ans = 1.0;
         long n= N;
         long n1 = n;
         if (n<0){
            n =-1*(n);
         }
        while(n>0){
            if(n%2==1){
                ans = ans*mid;
                n = n-1;
            }else{
                mid = mid*mid;
                n = n/2;
            }
        }
        System.out.println(ans);
        if(n1<0){
            return 1/ans;
        }else{
            return ans;
        }
      
    }
}