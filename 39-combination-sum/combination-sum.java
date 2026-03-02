 import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

      List<Integer> ans = new ArrayList<>();
      List<List<Integer>> result = new ArrayList<>();
     combinationSum(0,target,candidates,ans,0,result);
     return result;
    }



   public static void combinationSum(int sum , int tar , int arr[] ,List<Integer> ans,int idx ,List<List<Integer>> result ){
   if(sum==tar){
    result.add(new ArrayList<>(ans));
    return;
   }
   if(sum>tar){
    return;
   }
   
   for(int i = idx; i<arr.length ;i++){
        ans.add(arr[i]);
        combinationSum(sum+arr[i] , tar, arr, ans,i, result);
        ans.remove(ans.size()-1);
   }

      
   }

}