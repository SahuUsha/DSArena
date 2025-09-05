class Solution {
    public int makeTheIntegerZero(int num1, int num2) {


        for (int k = 1; k <= 60; k++) {  
            long diff = (long) num1 - (long) k * num2; 

            if (diff < 0) continue;

            if (diff >= k && Long.bitCount(diff) <= k) {
                return k;
            }
        }
        return -1;
    }
}



      
        
   