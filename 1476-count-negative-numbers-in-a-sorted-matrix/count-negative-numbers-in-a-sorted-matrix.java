class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;

        for(int[] arr : grid){
            for(int i =0 ; i<arr.length ; i++){

                if(arr[i]<0){
                    count++;
                }

            }
        }

        return count;
    }
}