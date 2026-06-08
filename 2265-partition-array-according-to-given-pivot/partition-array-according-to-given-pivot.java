class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less= new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for(int i = 0 ; i<nums.length ;i++){
            if(nums[i]<pivot){
                less.add(nums[i]);
            }else if(nums[i]>pivot){
                greater.add(nums[i]);
            }else{
                equal.add(nums[i]);
            }
        }
        System.out.println(less);
        System.out.println(equal);
        System.out.println(greater);
        
        int idx =0;
        for(int i = 0; i<less.size();i++){
            nums[idx++] = less.get(i);
        }
        for(int i =0 ;i<equal.size();i++){
            nums[idx++] = equal.get(i);
        }
        for(int i=0;i<greater.size();i++){
            nums[idx++] = greater.get(i);
        }

        return nums;
    }
}