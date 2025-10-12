class Solution {
    public int subarraySum(int[] nums, int k) {
       if(nums.length==1 && nums[0]==k){
        return 1;
       }

        int  prefixSum[] = new int[nums.length+1] ;
        int n = nums.length-1;
        int count = 0;

        

        for(int i = 1 ; i<=nums.length ; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];        
        }

        for(int i =0 ;i< prefixSum.length ;i++){
            System.out.println(prefixSum[i]+" ");
        }

      for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
        
    }
}