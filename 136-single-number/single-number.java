class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i] ,map.getOrDefault(nums[i], 0)+1 );
        }
int result =0 ;

        for(Map.Entry<Integer , Integer> ent : map.entrySet()){
            if(ent.getValue()==1){
                result = ent.getKey();
            }
        }

        return result;
        
    }
}