class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        Arrays.sort(a);  
        Stack<List<Integer>> result = new Stack<>();
        combination(a, s, 0, new ArrayList<>(), result);

        List<List<Integer>> finalans = new ArrayList<>();
        while(!result.isEmpty()){
            finalans.add(result.pop());
        }
        return finalans;
    }

    public static void combination(int[] a, int s, int idx, List<Integer> ans, Stack<List<Integer>> result){
        if(s==0){
            result.push(new ArrayList<>(ans));
            return;
        }

        for(int i = idx; i < a.length; i++){
            if(i > idx && a[i] == a[i-1]) continue;  
            if(a[i] > s) break;                      
            ans.add(a[i]);
            combination(a, s - a[i], i + 1, ans, result);
            ans.remove(ans.size()-1);
        }
    }
}