class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer , Integer>();
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] ,0) +1);
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>n/3){
                ans.add(entry.getKey());
            }
        }

        return ans;
        
    }
}