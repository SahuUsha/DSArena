class Solution {
    public void moveZeroes(int[] nums) {

        ArrayList<Integer> zero = new ArrayList<>();
        ArrayList<Integer> nonz = new ArrayList<>();

        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]==0){
                zero.add(nums[i]);
            }else{
                nonz.add(nums[i]); 
            }
        }
         int idx = 0;
        for(int d :  nonz){
          nums[idx++] = d;
        }

        for(int z : zero){
            nums[idx++] = z;
        }
        
    }
}