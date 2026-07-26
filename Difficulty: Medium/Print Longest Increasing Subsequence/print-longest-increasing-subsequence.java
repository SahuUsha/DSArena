class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        
        int cnt[] = new int[arr.length];
        int track[] = new int[arr.length];
        
        for(int i = 0  ; i<arr.length ; i++){
            track[i] = i;
        }
        
        int lastindex = 0;
        int max = 0;
        
        
        for(int i = 0 ; i<arr.length ; i++){
            
            for(int prev = 0 ; prev<i ; prev++){
                
                if(arr[i]>arr[prev] && cnt[prev]+1 > cnt[i]){
                    cnt[i] = cnt[prev] +1;
                    track[i] = prev;
                }
            }
            
            if(cnt[i]>max){
                max = cnt[i];
                lastindex = i;
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(track[lastindex]!=lastindex){
            list.add(arr[lastindex]);
            lastindex = track[lastindex];
        }
        
        list.add(arr[lastindex]);
        
        Collections.sort(list);
        
        return list;
    }
}
