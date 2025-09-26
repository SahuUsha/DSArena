class Solution {
    public void sortColors(int[] nums) {
        int help[] = new int[3];
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
                }else if(nums[i]==1){
                    oneCount++;
                }else if(nums[i]==2){
                   twoCount++;
                }
        }
        
        int idx = 0;
        for(int i = 0 ;i <nums.length; i++){
            if(zeroCount>0){
                nums[i] =0;
                zeroCount--;
            }else if(oneCount>0){
                nums[i] = 1;
                oneCount--;

            }else if(twoCount>0){
                nums[i] = 2;
               twoCount--;

            }
            
        }


        
    }
}