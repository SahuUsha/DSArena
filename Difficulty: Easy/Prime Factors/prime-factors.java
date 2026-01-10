class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i =2 ; i<=Math.sqrt(n) ; i++){
            if(n%i==0){
                ans.add(i);
                while(n%i==0){
                    n = n/i;
                }
            }
            
        }
        if(n!=1){
            ans.add(n);
        }
        
        return ans;
    }
}