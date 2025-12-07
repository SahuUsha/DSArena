class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        
        int cnt =0;
        int find =k-1;
        int i=0;
        int j=0;
        int n1 = a.length;
        int n2 = b.length;
    
        
        while(i<n1 && j<n2){
            
            if(a[i]<b[j]){
                if(cnt==find) return a[i];
                i++;
                cnt++;
            }else{
                 if(cnt==find) return b[j];
                j++;
                cnt++;
            }
        }
         while(i<n1){
             if(cnt==find) return a[i];
                i++;
                cnt++;
         }
        while(j<n2){
             if(cnt==find) return b[j];
                j++;
                cnt++;
         }
        
        return -1;
    }
}