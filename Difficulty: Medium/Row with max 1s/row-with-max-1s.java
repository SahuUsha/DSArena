class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxOnes = 0;
        int maxRow = -1;

        for (int r = 0; r < arr.length; r++) {
            int[] row = arr[r];
            int low = 0;
            int high = row.length - 1;

   
            while (low <= high) {
                int mid = (low + high) / 2;
                if (row[mid] == 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            
            int ones = row.length - low;

            if (ones > maxOnes) {
                maxOnes = ones;
                maxRow = r;
            }
        }

        return maxRow;
    }
}
