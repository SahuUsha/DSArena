class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // int []result = nums.length;
        
        Stack<Integer> stack = new Stack<>();
        int last = nums[nums.length-1];
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]>last){
                for(int j =nums.length-2; j>=0;j--){
                    stack.push(nums[j]);
                }
                stack.push(nums[nums.length-1]);
                nums[nums.length-1] = nums[i];
               
                break;
            }
        }

        if(stack.isEmpty()){
             stack.push(nums[nums.length-1]);
            nums[nums.length-1] = -1;
           
        }



        for(int i = nums.length-2; i>=0; i--){

            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }

            if( !stack.isEmpty() && stack.peek()>nums[i]){
                int prev = nums[i];
                nums[i] = stack.peek();
                stack.push(prev);
            }else{
                 stack.push(nums[i]);
                nums[i] = -1;
            }

        }
        return nums;
        
    }
}