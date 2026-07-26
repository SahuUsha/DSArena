class Solution {
    static int lis(int arr[]) {
        
        
        int max = 0;
        
        
        int cnt[] = new int[arr.length];
        Arrays.fill(cnt,1);
        
        for(int i = 0 ; i<arr.length ; i++){
            for(int prev = 0 ; prev<i ; prev++){
                
                if(arr[i]>arr[prev] && cnt[prev]+1 > cnt[i]){
                    cnt[i] = cnt[prev] + 1;
                }
                
            }
            
                if(cnt[i]>max){
                    max = cnt[i];
                }
            
        }
        
        return max;
        
    }
}