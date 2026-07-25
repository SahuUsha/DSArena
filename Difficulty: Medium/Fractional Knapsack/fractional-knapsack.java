class Solution {
    
    class Pair{
        int value;
        int wgt;
        
        Pair(int value, int wgt){
            this.value = value;
            this.wgt = wgt;
        }
    }
    
   public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        
        double values =0;
        
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i =0 ; i<val.length; i++){
            list.add(new Pair(val[i],wt[i]));
        }
        
        Collections.sort(list,(a,b)->Double.compare(
            (double)b.value/b.wgt, (double)a.value/a.wgt
            ));
        
        
        for(int i = 0 ; i<list.size();i++){
            Pair pr = list.get(i);
            if(pr.wgt<=capacity){
                capacity -=pr.wgt;
                values +=pr.value;
            }else{
               values += ((double) (pr.value)/(pr.wgt))*capacity;
               capacity -=capacity;
            }
        }
        
        return values;
    }
}