class Solution {
    public int jump(int[] nums) {
          int maxidx= 0;
          int jump =0;
          int end = 0;
           
           for(int i = 0 ; i<nums.length-1 ; i++){
            maxidx = Math.max(maxidx,i+nums[i]);

            if(i==end){
                jump++;
                end = maxidx;
            }
           }

         return jump;
    }
}