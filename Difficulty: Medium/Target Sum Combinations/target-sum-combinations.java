class Solution {
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>> finalans = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        CombinationSum(arr,target,0,finalans,ans);
        return finalans;
        
    }
    
     public void CombinationSum(int[] arr, int target, int idx, 
                               ArrayList<ArrayList<Integer>> finalans, 
                               ArrayList<Integer> ans) {
        
       
        if (target == 0) {
            finalans.add(new ArrayList<>(ans));
            return;
        }
        
        if (idx >= arr.length || target < 0) {
            return;
        }
        
        
        ans.add(arr[idx]);
        CombinationSum(arr, target - arr[idx], idx, finalans, ans);
        
      
        ans.remove(ans.size() - 1);
        
     
        CombinationSum(arr, target, idx + 1, finalans, ans);
    }
}