class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

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