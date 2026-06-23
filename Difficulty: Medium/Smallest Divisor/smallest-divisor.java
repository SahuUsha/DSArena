class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        
        int low = 1;
        int high = 0;
        for(int  i =0 ; i<arr.length;i++){
            high = Math.max(high,arr[i]);
        }
        int ans=0;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            int count = quotientsCount(arr,k,mid);
            
            if(count>k){
                low = mid+1;
            }else{
                ans =mid;
                high = mid-1;                                                                                   
            }
        }
        return ans;
        
    }
    
    int quotientsCount(int []arr,int k,int divisor){
        int qut = 0;
        
        for(int i = 0 ; i<arr.length;i++){
            
            if(arr[i]%divisor!=0){
                
                qut += (arr[i]/divisor) +1;
            }else{
                qut += arr[i]/divisor;
            }
        }
        
        return qut;
         
    }
    
}