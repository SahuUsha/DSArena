class Solution {
    public int trap(int[] height) {
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
}