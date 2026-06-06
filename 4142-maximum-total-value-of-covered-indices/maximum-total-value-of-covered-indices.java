class Solution {
    public long maxTotal(int[] nums, String s) {

        StringBuilder str = new StringBuilder(s);
        int zeroidx = -1;

        for(int i = 1;i<nums.length;i++){
            if(str.charAt(i)=='1'){
               if(str.charAt(i-1)=='0'){
                   zeroidx=i-1;
               }
                
                if(nums[i-1]>nums[i]){
                    if(str.charAt(i-1)=='0'){
                    str.setCharAt(i-1,'1');
                    str.setCharAt(i,'0');
                    zeroidx=i;
                    }
                   else if(zeroidx!=-1 && nums[zeroidx]>nums[i] ){
                        str.setCharAt(zeroidx,'1');
                    str.setCharAt(i,'0');
                    zeroidx=i;
                    }
                }
                else if(zeroidx!=-1 && nums[zeroidx]>nums[i] ){
                        str.setCharAt(zeroidx,'1');
                    str.setCharAt(i,'0');
                    zeroidx=i;
                    }
                }
                else{
                    zeroidx = i;
                }
             
            }
            
        
        long sum =0;
        System.out.println(str);
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                sum += nums[i];
            }
        }
        return sum;
    }
}