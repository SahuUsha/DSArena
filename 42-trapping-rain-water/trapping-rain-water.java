class Solution {
       public int trap(int[] height) {
        
        return maxWater(height);
        
        //  return trap1(height);
       }
    public int trap1(int[] height) {
        int total = 0 ;
        int n = height.length;
        int []preffixmax =new int[height.length]; 
        int []suffixmax =new int[height.length];
        preffixmax[0] = height[0];
        suffixmax[n-1] = height[n-1];
        for(int i = 1 ; i<preffixmax.length ; i++){
            preffixmax[i] = Math.max(height[i],preffixmax[i-1]);
        }
         for(int i = n-2 ; i>=0 ; i--){
           suffixmax[i]  = Math.max(height[i],suffixmax[i+1]);
        }

        for(int i = 0 ; i <n ; i++){
            int pref = preffixmax[i];
            int suff = suffixmax[i];
            if(height[i]<pref && height[i]<suff){
                total += Math.min(pref , suff)-height[i];
            } 
        }
        return total;

    }

     public int maxWater(int arr[]) {
        
        int n = arr.length;
        
       int leftmax = arr[0];
       int rightmax = arr[n-1];
       int l =0;
       int r = n-1;
       int total = 0;
       
       while(l<r){
          if(arr[l]<arr[r]){
              if(arr[l]>=leftmax){
                  leftmax = arr[l];
              }else{
                  total += leftmax - arr[l];
                  
              }
              l++;
          }else{
              if(arr[r]>=rightmax){
                  rightmax = arr[r];
              }else{
                  total += rightmax - arr[r];
                  
              }
              r--;
          }
       }
       
       return total;
    }

}