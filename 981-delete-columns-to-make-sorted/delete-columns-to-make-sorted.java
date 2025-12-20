class Solution {
    public int minDeletionSize(String[] strs) {
        
        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;

        // Check each column
        for (int col = 0; col < cols; col++) {
            // Compare characters row by row
            for (int row = 1; row < rows; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    count++;
                    break; // No need to check this column further
                }
            }
        }
        return count;
    }
}