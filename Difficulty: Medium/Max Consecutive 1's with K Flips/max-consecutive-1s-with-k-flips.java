class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        
        
        int l = 0 ; 
        int r = 0;
        int len = 0;
        
        while(l<arr.length  && r<arr.length){
            
            if(arr[r]==0){
                k--;
            }
            
            while(k<0){
                
                if(arr[l]==0){
                    k++;
                }
                l++;
            }
            
            len  = Math.max(len, r-l+1);
            r++;
        }
        
        return len;
    }
}