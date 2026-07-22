class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[]count = new int[nums.length];
        int cnt[] = new int[nums.length] ;
        int max = 0;
        Arrays.fill(count,1);
        Arrays.fill(cnt,1);
        int lastindex =0;
          
        for( int i=0 ; i<nums.length ;i++){
            for(int prev = 0 ; prev<i ; prev++){
                if(nums[prev]<nums[i] && count[prev]+1>count[i]){
                        count[i] = count[prev]+1;
                        cnt[i] =cnt[prev];
                }else if(nums[prev]<nums[i] && count[prev]+1==count[i]){
                              cnt[i]+=cnt[prev];
                }
            }
            if(count[i]>max){
                    max = Math.max(count[i],max);
                    lastindex = i;
            }
           }

            int result =0;
            for(int i =0; i<count.length ;i++){
                if(count[i]==max){
                    result+= cnt[i];
                }
            }
           
     return result;
}
}