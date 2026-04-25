class Solution {
      
    class Pair{
        int idx;
        double value;
        
        Pair(int idx, double value){
            this.idx = idx;
            this.value = value;
        }
    }
    
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        List<Pair>  list = new ArrayList<>();
        
        
        for(int i = 0 ; i<val.length ; i++){
            double cal = ((double) val[i]) / ( wt[i]);
            list.add(new Pair(i,cal));
        }
        
        list.sort((a,b)->Double.compare(b.value,a.value));
        double totalValue = 0;
        
        for(Pair p : list){
            int idx = p.idx;
            
            if(wt[idx]<=capacity){
                totalValue +=val[idx];
                capacity -=wt[idx];
            }else{
                totalValue += p.value * capacity;
                break;
            }
            
            
        }
        return totalValue;
        
        
    }
}