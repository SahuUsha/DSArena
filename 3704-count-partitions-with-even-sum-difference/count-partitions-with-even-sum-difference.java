class Solution {
    public int countPartitions(int[] nums) {
        int rsum= 0 ;
        int lsum = 0;
        int evenCount =0;
        for(int i=0; i<nums.length ;i++){
          rsum += nums[i];
        }

        for(int i=1;i<nums.length;i++){
          lsum +=nums[i-1];
          rsum -=nums[i-1];
          if( (Math.abs(lsum-rsum))%2==0 ){
            evenCount++;         
          }

          
        }

        return evenCount++;
    }
}