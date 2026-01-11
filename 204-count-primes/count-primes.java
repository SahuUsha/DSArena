class Solution {

    public int countPrimes(int n) {
        int  m = PrimeSieve(n);
    
        return m;
    }

    public static int PrimeSieve(int n){
        if(n==0 || n==1){
            return 0;
        }
      int count = 0; 
      int m = n;
        boolean []prime = new boolean[m];
        prime[0] = true;
        prime[1] = true;  // not prime
       

         for(int i =2 ; i*i<=n; i++){
            if(prime[i]==false){
                for(int j =i ; i*j<prime.length ; j++){
                    prime[i*j] = true;
                }
            }
         }
         for(int i=2 ; i< prime.length ; i++){
            if(prime[i]==false){
              count++;
            }
       }
       return count;
    }
     
     

    }
 

