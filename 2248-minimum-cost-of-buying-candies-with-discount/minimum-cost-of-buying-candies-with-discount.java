class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;
        if(cost.length==1){
            return cost[0];
        }else if(cost.length==2){
            return cost[0]+cost[1];
        }

        int totalSum =0;
        for(int i = 0; i<cost.length ;i++){
            totalSum +=cost[i];
        }
      
      int temp=0;
        for(int i = cost.length-3 ; i>=0;i = i-3){
           temp += cost[i];
        }
        
        return totalSum - temp;
    }
}