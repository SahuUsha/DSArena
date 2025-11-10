class Solution {
    public int findKRotation(int nums[]) {
        // Code here
        int low = 0 ;
        int high = nums.length -1;
        int min = Integer.MAX_VALUE;
        int index= 0;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                if(nums[low]<min){
                min = Math.min(min,nums[low]);
                index = low;
                }
                low = low+1;

            }else{
                
                if(nums[mid]<min){
                index = mid;
                min = Math.min(min , nums[mid]);
                }
                high = mid-1;
            }
        }

        return index;
        
    }
}