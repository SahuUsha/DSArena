// User function Template for Java

class Solution {
    
    public int numberOfSubarrays(int[] arr, int target) {
        return  numberOfSubarrays1(arr,target) - numberOfSubarrays1(arr,target-1);
        
        
    }
    
    public int numberOfSubarrays1(int[] arr, int target) {
        // code here
        int sum = 0 ;
        int cnt  = 0;
        int l = 0 ;
        int r = 0;
        
        while(r<arr.length){
            sum += arr[r];
            
            while(sum>target){
                sum -=arr[l];
                l++;
            }
            
            cnt = cnt +(r-l+1);
            r++;
            
        }
        
        return cnt;
    
        
    }
}