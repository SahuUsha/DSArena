class Solution {
    public int countSubarrays(int[] arr, int k) {
        
        return countArray(arr,k) - countArray(arr,k-1);
        // code here
        
    }
    public int countArray(int []arr, int k){
        int l = 0;
        int r = 0;
        int ans =0;
        int countOdd=0;
        
        while(r<arr.length){
            
            if((arr[r] & 1)==1){
                countOdd++;
            }
            
            while(countOdd>k){
            
                
                
            if((arr[l] & 1)==1){
                countOdd--;
            }
            
            l++;
            }
            
            ans += r-l+1;
            r++;
            
        }
        
        return ans;
    }
}
