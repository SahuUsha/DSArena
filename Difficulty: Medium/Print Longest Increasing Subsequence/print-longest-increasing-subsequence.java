class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
          return LargestDivisibleSubsets(arr);
    }
    public ArrayList<Integer> LargestDivisibleSubsets(int[] arr){
        int len[] = new int[arr.length];
        int parent[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
    parent[i] = i;
}
        int max = 0;
        int lastidx = 0;
        
        Arrays.fill(len,1);
        
        for(int i =  0; i<arr.length ; i++){
            for(int prev = 0 ; prev<i ; prev++){
                
                if(arr[i]>arr[prev] && 1+len[prev] > len[i]){
                      len[i] = 1+len[prev];
                      parent[i] = prev;
                    
                    
                }
            }
            if(len[i]>max){
                max = len[i];
                lastidx = i;
            }
        }
    
        ArrayList<Integer> list = new ArrayList<>();
        while(lastidx!=parent[lastidx]){
            list.add(arr[lastidx]);
            lastidx = parent[lastidx];
        }
        
        list.add(arr[lastidx]);
         Collections.reverse(list);
        
        return list;
    }
}
