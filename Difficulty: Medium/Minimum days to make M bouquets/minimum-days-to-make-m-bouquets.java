class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = -1;
        
        for(int i=0 ;i<arr.length;i++){
            low = Math.min(low,arr[i]);
            high = Math.max(high,arr[i]);
        }
        
        
        while(low<=high){
             int mid = (low+high)/2;
            
            int day = bouquetCount(arr,mid,k);
            
            if(day==m){
                ans = mid;
                 high = mid-1;
            }
            else if(day<m){
                low = mid+1;
            }else{
                ans = high;
                high = mid-1;
            }
        }
        return ans;
        
        
    }
    
    public int bouquetCount(int []arr,int day,int k){
        int req = 0;
        int count = 0;
        
        for(int  i = 0 ; i<arr.length ;i++){
            
            if(arr[i]<=day){
                req++;
            }else{
                count += req/k;
                req=0;
            }
        }
        
        count += req/k;
        
        return count;
    }
}