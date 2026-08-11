class Solution {
    static int solve(int bt[]) {
        // code here
        
      Arrays.sort(bt);
      
      int result = 0;
      int sum = 0;
      
      for(int i = 0 ; i<bt.length-1 ; i++){
          
          sum = sum + bt[i];
          result += sum;
          }
    //   System.out.println(result);
    
    return result/bt.length;
    }
}
