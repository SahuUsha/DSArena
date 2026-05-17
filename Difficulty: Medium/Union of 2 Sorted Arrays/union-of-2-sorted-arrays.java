class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        
        Set<Integer> set = new HashSet<>(); 
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n1 = a.length;
        int n2 = b.length;
        
        
       while(i<n1 && j<n2){
           if(a[i]<b[j]){
               if(!set.contains(a[i])){
                   set.add(a[i]);
               list.add(a[i]);
               }
               i++;
           }else if(b[j]<a[i]){
                if(!set.contains(b[j])){
                    set.add(b[j]);
               list.add(b[j]);
               }
               j++;
           }else{
               
               if(!set.contains(a[i])){
                   set.add(a[i]);
               list.add(a[i]);
               }
               
               i++;
               j++;
           }
       }
       
       while(i<n1){
            if(!set.contains(a[i])){
                set.add(a[i]);
               list.add(a[i]);
               }
           i++;
       }
      
      while(j<n2){
           if(!set.contains(b[j])){
               set.add(b[j]);
               list.add(b[j]);
               }
          j++;
      }
      
      
      
      return list;
        
    }
}
