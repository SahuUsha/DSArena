class Solution {
    public static void print_divisors(int n) {
        // code here
        if(n==1){
            System.out.print(1);
            return;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        
        for(int i =1 ;i<=Math.sqrt(n);i++){
            if(n%i==0){
                ans.add(i);
                if(n/i!=i){
                    ans.add(n/i);
                }
            }
        }
        
        Collections.sort(ans);
        for(int e : ans){
            if(e==n){
              System.out.print(e);
              return;
            }else{
                System.out.print(e+" ");
            }
            
        }
        
    }
}
