class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int l = 0 ,r=0;
        
        int MaxLen =0;
        
        while(r<arr.length){
            
            while(arr[r]==0 && k<=0){
                
                if(arr[l]==0){
                    k++;
                }
                l++;
                
            }
            
            
            if(arr[r]==0){
                k--;
            }
            int len = r-l+1;
            MaxLen = Math.max(MaxLen,len);
            
            r++;
        }
        
        return MaxLen;
    }
}