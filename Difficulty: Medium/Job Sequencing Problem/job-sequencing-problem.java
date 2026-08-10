class Solution {
    class ProfitjobMap{
        int deadline;
        int profit;
        
        ProfitjobMap(int profit , int deadline){
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    
    int find(int []parents, int x){
        if(parents[x]==x){
            return x;
        }
        
        return parents[x] = find(parents, parents[x]);
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int max = Integer.MIN_VALUE;
        ArrayList<ProfitjobMap> list = new ArrayList<>();
        
        for(int i = 0 ; i<deadline.length ; i++){
            max = Math.max(max,deadline[i]);
            list.add(new ProfitjobMap(profit[i],deadline[i]));
        }
        
         int[] parent = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            parent[i] = i;
        }
        
        // Arrays.fill(jobarr,-1);
        
        Collections.sort(list, (a, b) -> Integer.compare(b.profit, a.profit));
        
        int maxProfit = 0;
        int jobcount =0;
        
        // for(int i=0; i<list.size();i++){
            
        //     ProfitjobMap job = list.get(i);
        //     int dead = job.deadline;
            
        //     while(dead>0 && jobarr[dead]!=-1){
        //         dead--;
        //     }
            
        //     if(dead > 0 && jobarr[dead]==-1){
        //         jobarr[dead] = job.deadline;
        //         maxProfit +=job.profit;
        //         jobcount++;
        //     }
            
        // }
        
        for(ProfitjobMap job : list){
            
            int slot = find(parent, job.deadline);
            
            if(slot>0){
                
                jobcount++;
                maxProfit += job.profit;
                
                parent[slot] = find(parent,slot-1);
            }
            
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobcount);
        result.add(maxProfit);
        return result;
    }
}