class Solution {
    public int distinctPrimeFactors(int[] nums) {

//***************** TLE********** */

    //     long product =1;
    //     for(int n : nums){
    //         product *= n;
    //     }
    
    //  return  (int) primeFac(product);

//***************** TLE********** */ 

   HashSet<Integer> set = new HashSet<>();
    
    for(int n : nums){
        for(int i=2 ; i * i <= n;i++){
            if(n%i==0){
                set.add(i);
                 while(n%i==0){
                    n = n/i;
                }
            }
        }
           if (n > 1) {
                set.add(n);
            }
            
    }
    return set.size();
        
        
    }

    public static int primeFac(long n) {
        // code here
        int count=0;
        for(int i =2 ; i<=Math.sqrt(n) ; i++){
            if(n%i==0){
                count++;
                while(n%i==0){
                    n = n/i;
                }
            }
            
        }
        if(n!=1){
            count++;
        }
        
        return count;
    }
}