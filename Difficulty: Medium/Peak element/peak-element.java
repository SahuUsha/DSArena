class Solution {
    public int peakElement(int[] nums) {
        // code here
        
        int n = nums.length;
        int low = 1;
        int high = n-2;

        if(n==1) return 0;

        if(nums[0]>nums[1]) return 0;

        if(nums[n-1]>nums[n-2]) return n-1;

        while(low<=high){
            int mid = (low+high)/2;
 
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if((nums[mid]>nums[mid-1])){
                low = mid+1;
            }
            else if((nums[mid]>nums[mid+1])){
                high = mid-1;
            }else{
                // if mid == reciprocal to peek mean => down point between two slope
                // take update any value
                high = mid-1;
            }
        } 
        return -1;
    }
}