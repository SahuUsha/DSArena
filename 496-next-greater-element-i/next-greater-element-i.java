class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();


        for(int i = 0 ;i< nums2.length ; i++){
            map.put(nums2[i],i);

        }

        int []res = new int[nums1.length];
        

        for(int  i = 0 ; i<nums1.length ; i++){
            int ele = nums1[i];
            int idx = map.get(ele);

            int nextGreater = -1;

            for(int j = idx ; j<nums2.length ; j++){
                if(nums2[j] > ele){
                    nextGreater = nums2[j];
                    break;
                }
            }
             res[i] = nextGreater;
        }

        return res;
    }
}