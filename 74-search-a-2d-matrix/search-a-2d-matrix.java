class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int low = 0;
        int n =  matrix.length;
        int m  = matrix[0].length;
        int high = (n*m)-1;

        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col]==target){
                return true;

            }
            else if(matrix[row][col]>target){
                 high = mid-1;
            }else{
                low = mid+1;
            }

        }
     return false;
      
    }
     public static boolean searxm(int[][] matrix, int target){
           for (int r = 0; r < matrix.length; r++) {
            int[] row =matrix[r];
            int low = 0;
            int high = row.length - 1;

   
            while (low <= high) {
                int mid = (low + high) / 2;
                if(row[mid]==target){
                       return true;
                }
                else if (row[mid]>target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
            return false;
            
            }
}