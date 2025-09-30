class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        ArrayList<Integer> newnum = new ArrayList<>();
        for(int nm : nums ){
            newnum.add(nm);
        }

        return result(newnum);
    }
    public int result(ArrayList<Integer> ans) {
    while (ans.size() > 1) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i < ans.size(); i++) {
            int first = ans.get(i - 1);
            int sec = ans.get(i);
            temp.add((first + sec)%10);
        }
        ans = temp; 
    }
    return ans.get(0); 
}
}