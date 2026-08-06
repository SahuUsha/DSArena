class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
        
        // return minPath(triangle, 0, 0);
        return tabulation(triangle);
    }
    
    public int minPath(ArrayList<ArrayList<Integer>> triangle , int row, int col){
        
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        
        if(col<0 || col>=triangle.get(row).size()){
            return 0;
        }
        
       int path1 = minPath(triangle, row+1, col);
       int path2 = minPath(triangle, row+1,col+1);
       
       int min = Math.min(path1,path2);
       
       
       return triangle.get(row).get(col) + min;
        
    }
    
    public int tabulation(ArrayList<ArrayList<Integer>> triangle){
        
        int dp[][] = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        
        for(int i = 0 ; i<triangle.get(triangle.size()-1).size() ; i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        
        for(int  i =triangle.size()-2   ; i >=0; i--){
            int min  = Integer.MAX_VALUE;
            for(int   j = 0  ; j<triangle.get(i).size();j++){
                min = Math.min(dp[i+1][j], dp[i+1][j+1]);
                dp[i][j] = triangle.get(i).get(j) + min;
            }
        }
        
        return dp[0][0];
    }
}