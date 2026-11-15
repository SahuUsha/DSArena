class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;

        for(int i =0  ;i<nums.length; i++){
            xor ^= nums[i];
        }

        int rightMost = xor & -xor;

        int num1 =0;
        int num2 = 0;

        for(int num : nums){

            if((num & rightMost) != 0){
                num1 ^=num;

            }else{
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}