class Solution {
    public void solve(char[][] board) {
        
       
        boolean vis[][] = new boolean[board.length][board[0].length];

        int []drow = {0,-1,0,1};
        int dcol[] = {1,0,-1,0};
        int n = board.length;
        int m = board[0].length;

        for(int j = 0 ; j<board[0].length ; j++){
            if(!vis[0][j] && board[0][j]=='O'){
               DFS(0, j,  board,drow,dcol,vis);
            }

            if(!vis[n-1][j] && board[n-1][j]=='O'){
                DFS(n-1,j,board,drow,dcol,vis);
            }
        }

        for(int i =0; i<board.length ; i++){
            if(!vis[i][0] && board[i][0]=='O'){
                DFS(i, 0 ,board, drow, dcol,vis);
            }

            if(!vis[i][m-1] && board[i][m-1]=='O'){
                DFS(i, m-1,board, drow, dcol, vis);
            }
        }

        for(int i =0 ; i<n; i++){
            for(int j = 0 ; j<m; j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

        
    }

    public void DFS(int row, int col, char [][] board, int[] drow, int[] dcol, boolean vis[][]){
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            
            if(nrow>=0 && ncol>=0 && nrow<board.length && ncol<board[0].length && !vis[nrow][ncol] && board[nrow][ncol]=='O'){

                DFS(nrow,ncol,board,drow,dcol,vis);
            }
        }    
    }
}