class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // code here.
        
        int n = cardPoints.length;
        
        int windowSize = n -k;
        
        int windowsum = 0;
        int totalSum = 0;
        int maxsum = 0;
        
        for(int  i = 0 ; i<cardPoints.length ; i++){
            totalSum += cardPoints[i];
        }
        
        if(n==k) return totalSum;
        
        for(int  j = 0 ; j<windowSize ;j++){
            windowsum += cardPoints[j];
        }
          maxsum = Math.max(maxsum , totalSum-windowsum);
            
        for(int i = windowSize  ; i <cardPoints.length; i++){
            windowsum =  windowsum+cardPoints[i];
            windowsum =  windowsum-cardPoints[i-windowSize];
            
            maxsum = Math.max(maxsum , totalSum-windowsum);
            
        }
        return maxsum;
    }
}
