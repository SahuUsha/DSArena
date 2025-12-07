class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cnt=0;
        int idxe1 = -1;
        int idxe2= -1;
        int i=0;
        int j=0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n =n1+n2;
        
      int idx1 = ((n1+n2)/2)-1;
      int idx2 = ((n1+n2)/2);
      

        
        while(i<n1 && j<n2){

            if(nums1[i]<nums2[j]){
                if(cnt==idx1) idxe1 = nums1[i];
                if(cnt==idx2) idxe2 = nums1[i];
                i++;
                cnt++;

            }else{
               if(cnt==idx1) idxe1 = nums2[j];
                if(cnt==idx2) idxe2 = nums2[j];
                j++;
                cnt++;

            }
        }
        while(i<n1){
             if(cnt==idx1) idxe1 = nums1[i];
                if(cnt==idx2) idxe2 = nums1[i];
                i++;
                cnt++;
        }

        while(j<n2){
            if(cnt==idx1) idxe1 = nums2[j];
                if(cnt==idx2) idxe2 = nums2[j];
                j++;
                cnt++;
        }

        if(n%2==1){
            return idxe2; 
        }
      return (double) ((double)(idxe1+idxe2))/2.0;       
    }
}