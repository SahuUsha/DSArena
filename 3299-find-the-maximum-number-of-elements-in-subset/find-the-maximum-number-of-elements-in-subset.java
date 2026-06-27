class Solution {
    public int maximumLength(int[] nums) {
        long maxValue =Integer.MIN_VALUE;
        HashMap<Long,Integer> map = new HashMap<>();
        for(int i=0 ;i<nums.length;i++){
            maxValue = Math.max(maxValue , (long)nums[i]);
            map.put((long)nums[i],map.getOrDefault((long)nums[i],0)+1);
        }
       int MaxSubSet  =1;

        for(long start : map.keySet()){
            int count = 0;
            long num = start;
            
            if(num==1){
                count = map.get((long)1);
                if(count%2==0){
                    count = count-1;
                }
            }else{

            while(num<=maxValue && map.containsKey(num)){

                 long next = num*num;
                
               if(map.get(num)>=2 && map.containsKey(next) ){
                count += 2;
               num  = num*num;
               }else{
                count += 1;
                break;
               }

            }
            }
               MaxSubSet = Math.max(MaxSubSet ,count);
        }

        return MaxSubSet;
    }
}