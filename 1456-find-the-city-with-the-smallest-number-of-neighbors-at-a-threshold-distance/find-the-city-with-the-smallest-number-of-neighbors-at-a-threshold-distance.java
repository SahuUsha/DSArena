class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int INF = 10001;
        int [][] dist = new int[n][n];

        for(int i=0;i<n ; i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (i==j) ? 0 : INF;
            }
        }

        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;

        
        }

        for(int k =0 ; k<n ; k++){
            for(int i = 0 ; i<n ; i++){
                for(int j=0; j<n ; j++){
                 if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
  int resultCity = -1;
        int minReachable = n;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Tie-breaker: prefer larger city index
            if (count <= minReachable) {
                minReachable = count;
                resultCity = i;
            }
        }

        return resultCity;

        
    }
}