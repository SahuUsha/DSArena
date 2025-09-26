class Solution {
    public int majorityElement(int[] nums) {
       if(nums.length==1){
        return nums[0];
       }

        Arrays.sort(nums);
        int count = 1;
        for(int i = 0 ; i<nums.length-1 ; i++){
            if(nums[i]!=nums[i+1]){
              count=0;
            }

            count++;
            System.out.println(count);
            if(count>(nums.length/2)){
                return nums[i];
            }


        }
        return 0;
        
    }
}