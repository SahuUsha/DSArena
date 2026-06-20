class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        boolean []visited = new boolean[leaves+1];
       
        
        
       for (int frog : frogs) {
    if (frog > leaves || visited[frog]) {
        continue;
    }

    for (int j = frog; j <= leaves; j += frog) {
        visited[j] = true;
    }
}
        
        int count = 0;
        for(int i =1;i<visited.length;i++){
            if(visited[i]==false){
                count++;
            }
        }
        
        return count;
    }
}
