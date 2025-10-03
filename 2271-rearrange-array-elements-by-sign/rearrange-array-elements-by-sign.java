class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> posi =new LinkedList<>();
        Queue<Integer> nega = new LinkedList<>();

        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]<0){
                nega.offer(nums[i]);
            }else{
                posi.offer(nums[i]);
            }
        }

        int result[] = new int[nums.length];

        for(int i =0  ; i<nums.length ;i++){
            if(i%2==0){
              result[i] = posi.poll();
            }else{
                 result[i] = nega.poll();
            }
        }

        return result;
                
    }
}