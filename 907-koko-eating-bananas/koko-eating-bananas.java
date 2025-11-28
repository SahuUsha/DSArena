class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
         for(int pile : piles){
            high = Math.max(high,pile);
         }
   
        while(low<high){
            int mid =  low + (high - low) / 2;;
            int hour = hourtaketoeat(piles,mid);
          if(hour>h){
           low = mid+1;
        }else{
            high = mid;
        }
        }
        return low;
    }

    public int hourtaketoeat(int []piles , int mid){
        int counthr = 0;
        for(int i = 0;i<piles.length;i++){
            counthr += (piles[i] + mid - 1)/mid;
        }
        return counthr;
    }
}