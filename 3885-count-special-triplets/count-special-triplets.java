class Solution {
    static final int MOD = 1000000007;
     
    public int specialTriplets(int[] nums){
        int ans =0;
       
       HashMap<Integer, Integer> Rmap = new HashMap<>();
       HashMap<Integer, Integer> Lmap = new HashMap<>();

       for(int num : nums ){
        Rmap.put( num ,Rmap.getOrDefault(num,0)+1);
       }
       
       for(int j=0;j<nums.length ; j++){
         
          Rmap.put( nums[j] ,Rmap.getOrDefault(nums[j],0)-1);
          int midv = nums[j]*2;
          

          if(j>0){
            int Lcount = Lmap.getOrDefault(midv,0); 
            int Rcount = Rmap.getOrDefault(midv,0);

               long add = (long) Lcount * Rcount % MOD;
                 ans = (ans + (int) add) % MOD;
          }
           Lmap.put( nums[j] ,Lmap.getOrDefault(nums[j],0)+1);
       }
      return ans;

    }

    public int specialTriplets1(int[] nums) {
        int ans =0;    
        for(int j=1; j<nums.length;j++){
           int mid = nums[j]*2;
           int Lcount=0;
           int Rcount =0;
           for(int i =0;i<j;i++){
            if(nums[i]==mid){
                Lcount++;
            }
           }
            for(int k =j+1;k<nums.length;k++){
            if(nums[k]==mid){
                Rcount++;
            }
           }
          ans +=(int) (Rcount*Lcount) % MOD;
    }
    return ans;
}
}