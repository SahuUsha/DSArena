class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        
         int left = maxValueleft(arr, target);

        // Target not found
        if (left == -1) {
            return 0;
        }

        int right = maxValueright(arr, target);

        return right - left + 1;
        
    }
    
    int maxValueleft(int []arr,int target){
        int ans = -1;
        
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(arr[mid]==target){
                ans = mid;
                high = mid-1;
                
            }else if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        
        return ans;
        
    }
    
    int maxValueright(int []arr,int target){
        int ans = -1;
        
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(arr[mid]==target){
                ans = mid;
                low = mid+1;
            }else if(arr[mid]>target){
                
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        
        return ans;
        
    }
    
}
