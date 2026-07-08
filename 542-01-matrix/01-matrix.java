class Solution {
  class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
  }

    public int[][] updateMatrix(int[][] mat) {
        
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int result[][] = new int[mat.length][mat[0].length];

        for(int i = 0 ;i<mat.length;i++){
            for(int j = 0 ;j<mat[0].length;j++){
                if(mat[i][j]==0 && !visited[i][j]){
                    queue.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};

        while(!queue.isEmpty()){
            Pair pr = queue.poll();
            int row = pr.row;
            int col = pr.col;
           
           for(int i =0 ;i<4;i++){
            int newrow = row + drow[i];
            int newcol = col + dcol[i];

            if(newrow>=0 && newrow<result.length &&
               newcol>=0 && newcol<result[0].length){
                if(!visited[newrow][newcol]){
                    result[newrow][newcol] = result[row][col]+1;
                    queue.add(new Pair(newrow,newcol));
                    visited[newrow][newcol]=true;
                }
               }

           }


        }

        return result;
    }
}