class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int totalSum = 0;

        for(int num : cardPoints ){
            totalSum += num;
        }

        if(k==n){
            return totalSum;
        }

        int windowSize = n-k;

        int windowSum = 0;

        for(int  i =0 ; i<windowSize ;i++){
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        for(int i = windowSize ; i<cardPoints.length;i++){
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i-windowSize];

            minSum = Math.min(minSum,windowSum);
        }

        return totalSum - minSum;
    }
}