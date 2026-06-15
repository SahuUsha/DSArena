class Solution {
    public int findMin(int[] arr) {
        // code here
        return findMinsum(arr);
        
    }
    
    public int findMinsum(int []arr){
        int low = 0;
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;
        
         while(low<=high){
             
             int  mid = (low+high)/2;
             
             if(arr[low]<=arr[mid]){
                 min = Math.min(min,arr[low]);
                 low = mid+1;
             }else{
                 min = Math.min(min,arr[mid]);
                 high = mid-1;
             }
             
         }
        
        
        return min;
    }
}
