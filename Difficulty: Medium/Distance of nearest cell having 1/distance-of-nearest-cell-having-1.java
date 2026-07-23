class Solution {
    
    class Pair{
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        Queue<Pair> queue = new LinkedList<>();
        int [][]result = new int[grid.length][grid[0].length];
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        for(int i =0 ; i<grid.length;i++){
            for(int j =0 ; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j]==1){
                    queue.add(new Pair(i,j));
                    visited[i][j] = true;
                    
                }
            }
        }
        
        
        int drow[] = {-1, 0, 1,0};
        int dcol[] = {0,-1,0,1};
        
        
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            
            for(int i = 0 ; i<4 ; i++){
                int newRow = row + drow[i];
                int newCol = col + dcol[i];
                
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length)
                {
                    
                if(!visited[newRow][newCol]){
                    result[newRow][newCol] = result[row][col] + 1;
                    queue.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
                
                }
            }
        }
        
        ArrayList<ArrayList<Integer>>  list = new ArrayList<>() ;
        for(int i  = 0 ; i<result.length ; i++){
            ArrayList<Integer> res= new ArrayList<>();
            for(int j = 0 ; j<result[0].length ; j++){
                res.add(result[i][j]);
            }
            list.add(res);
        }
        
        return  list;
    }
}