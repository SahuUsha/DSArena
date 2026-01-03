class Solution {
    public int sumFourDivisors(int[] nums) {

        int sum =0;
        for(int n : nums){
            int count=0;
            int temp =0;
            for(int i=1;i<=Math.sqrt(n);i++){
                if(n%i==0){
                 count++;
                 temp +=i;
                if(n/i!=i){
                   temp += (n/i);
                   count++;
                }
            }

           }
           if(count==4){
            sum+=temp;
           }
        }
        return sum;
      
        
    }
}