class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();

        int j = 0;

        while(j<intervals.length && intervals[j][1] < newInterval[0]){
            list.add(intervals[j]);
            j++;
        }
        
        while(j<intervals.length && newInterval[1]>=intervals[j][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[j][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[j][1]);

            j++;

        }

        list.add(newInterval);

        while(j<intervals.length){
            list.add(intervals[j]);
            j++;
        }



        int result[][] = new int[list.size()][2];

        for(int i = 0 ; i<result.length ; i++){
            result[i] = list.get(i);
        }

        return result;


    }
}