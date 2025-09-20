class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
         if (k == 0) return;
        int d = len -k;

        int temp[] = new int[k];
        int idx = 0;
 
        for(int i = d ; i<len ; i++){
            temp[idx++] = nums[i];
        }

        
        for(int i = d-1; i>=0 ;i--){
            nums[i+k] = nums[i];
        }

        for(int  i = 0 ; i<temp.length ;i++){
            System.out.println(temp[i]);
             nums[i] = temp[i];
        }



        
        
        
    }
}