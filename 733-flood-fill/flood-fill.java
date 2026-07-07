class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        // int [][]copy = image;
        int original = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        int [][]vis = new int[image.length][image[0].length];
        q.offer(new Pair(sr,sc));
        image[sr][sc]=color;
        vis[sr][sc] =1;
        int []drow = {-1,0,+1,0};
        int []dcol = {0,+1,0,-1};

        while(!q.isEmpty()){

            Pair pr = q.poll();

            for(int i=  0 ; i<4;i++){
                int nrow = pr.row + drow[i];
                int ncol = pr.col + dcol[i];

                if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length
                  && vis[nrow][ncol]==0 && image[nrow][ncol]== original){
                    q.offer(new Pair(nrow,ncol));
                    image[nrow][ncol] = color;
                    vis[nrow][ncol] = 1;
                }

            }

        }

        return image;
    }
}