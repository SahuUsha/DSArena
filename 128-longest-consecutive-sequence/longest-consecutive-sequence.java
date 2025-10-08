class Solution {
    public int longestConsecutive(int[] nums) {
        // return LongestConsecuriveElement(nums);
        return longCons2(nums);
    }

    public int longCons2(int[] nums){
        HashSet<Integer> set = new HashSet<Integer>();
        int maxlen = 0;


        for(int  i = 0 ;i<nums.length ; i++){
            set.add(nums[i]);
        } 

        for (int num : set) {
            // Start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxlen = Math.max(maxlen, count);
            }
        }
        
        return maxlen;

    }



    //  public int longCons(int[] nums){

    //     Arrays.sort(nums); 

    //     int longestseq = 1;
    
    //     int lenCurr = 0;
    //     int secondSmaller = Integer.MIN_VALUE;
    //     for(int i = 0 ; i<nums.length ; i++){
    //         if(nums[i]-1 ==  secondSmaller){
    //             lenCurr = lenCurr +1 ;
    //             secondSmaller = nums[i];
    //         }else if(nums[i]!= secondSmaller){
    //                lenCurr =1;
    //                 secondSmaller = nums[i];
    //         }
    //        longestseq = Math.max(longestseq,lenCurr);
    //     }
    //     return  longestseq;

    //  }



    //  public static int LongestConsecuriveElement(int []nums){
        
    //     HashMap<Integer , Boolean> map = new HashMap<>();

    //     // find starting point
    //     for(int i = 0 ;i <nums.length ; i++){
    //         if(map.containsKey(nums[i]-1)){
    //             map.put(nums[i] , false);
    //         }
    //         else{
    //             map.put(nums[i] , true);
    //         }
    //         if(map.containsKey(nums[i] +1)){
    //             map.put(nums[i]+1 , false);
    //         }
    //     }
        
    //     int ans=0;
    //     for(int key : map.keySet()){
    //         if(map.get(key)){
    //             int count =0 ;
    //             while(map.containsKey(key)){
    //                 count++;
    //                 key++;
    //             }
    //             ans = Math.max(ans ,count);
    //         }
    //     }
    //     return ans;
    // }
}