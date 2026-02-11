class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
      

        for(int i = nums.length-1; i>=0; i--){

            while(!stack.isEmpty() && stack.peek()>=nums[i]){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek()<nums[i]){
                list.add(stack.peek());
                stack.push(nums[i]);
            }else{
                stack.push(nums[i]);
                list.add(-1);
            }

        }
        
        Collections.reverse(list);
        return list;
        


    }
}