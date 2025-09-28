class Solution {
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        int maxArea = 0;

        for(int i= 0 ; i<nums.length-2 ; i++){
            
                for(int k=i+2 ; k<nums.length ; k++){
                    if(nums[i]+nums[i+1]>nums[k]){
                    int area = nums[i]+nums[i+1]+nums[k];
                    if(maxArea<area){
                        maxArea = area;
                    }

                    }

                }
          
        }
        return maxArea;
        
    }
}