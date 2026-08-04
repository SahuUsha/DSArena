class Solution {
    
    int unvisitedLeaves(int arr[], int k) {
        // code here
        
        boolean []visited = new boolean[k+1];
        
        for(int num : arr){
            
            
            if(num>k){
                continue;
            }
            
            
            for(int i = num ; i<=k ; i +=num){
                visited[i] = true;
            }
            
        }
        
        int count = 0;
        
        for(int i = 1 ; i<visited.length ; i++){
            if(!visited[i]){
                count++;
            }
        }
        
        
        return count;
    }
    
    
}