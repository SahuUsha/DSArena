class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        
        int  n = stalls.length;
        Arrays.sort(stalls);
        
        
        int low = 1; 
        int high = stalls[n-1]-stalls[0];
        while(low<=high){
            int mid = (low + high)/2;
            
            if(canbePlace(stalls, mid,k)==true){
                low = mid+1;
                
            }else{
                high = mid-1;
            }
        }
        return high;
        
    }
    
    public static boolean canbePlace(int[] stalls, int dist ,int cows){
        int cntCow = 1;
        int last = stalls[0];
        
        for(int i = 1 ; i<stalls.length;i++){
            
            if(stalls[i]-last>=dist){
                cntCow++;
                last = stalls[i];
            }
        if(cntCow>=cows){
            return true;
        }
        }
        
            return false;
        
    }
}