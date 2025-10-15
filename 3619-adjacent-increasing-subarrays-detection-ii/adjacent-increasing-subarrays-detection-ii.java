class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int  i = 1;       
        int  n=  nums.size();
        int prev=0;
        int countfr =1;
        int res =0;
        while(i<n){

            if(nums.get(i) >nums.get(i-1)){
                countfr++;
            } else{
                prev = countfr;
                countfr=1;
            }      

            int half = countfr>> 1;
            int min = prev < countfr ? prev :countfr;   
            int candidate = half > min ?  half : min;
            if (candidate > res) res = candidate;

            i++;
        }
        return res;
        
    }
}