class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row, int col, int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        
        Queue<Pair> queue = new LinkedList<>();
        int [][]visited = new int[grid.length][grid[0].length];
        
        int [][]result = new int[grid.length][grid[0].length];
        
        for(int i = 0 ;i<grid.length;i++){
            for(int j  =0 ;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        
        int []drow={-1,0,1,0};
        int []dcol ={0,1,0,-1};
        
        while(!queue.isEmpty()){
            
            Pair pr = queue.poll();
            
            int row = pr.row;
            int col = pr.col;
            
            for(int i = 0 ; i<4;i++){
                int newRow = row+drow[i];
                int newCol = col+dcol[i];
                
                
                if(newRow>=0 && newRow<grid.length && 
                newCol>=0 && newCol<grid[0].length && visited[newRow][newCol]==0 ){
                    visited[newRow][newCol] = 1;
                    queue.add(new Pair(newRow,newCol,pr.dis+1));
                    result[newRow][newCol] = pr.dis+1;
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i  = 0 ; i<grid.length;i++){
            list.add(new ArrayList<>());
            for(int j = 0 ;j<grid[0].length;j++){
                list.get(i).add(result[i][j]);
            }
        }
        
        return list;
    }
    
    
}