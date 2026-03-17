class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;

        if(m!=0 && n!=0){
            while(i<m){
            if(nums1[i]>nums2[j]){
                int t=nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=t;
            }
            i++;
        }
        }
        
        if(n!=0){
            Arrays.sort(nums2);
            while(i<m+n){
            nums1[i]=nums2[i-m];
            i++;
        }
        }

        
    }
}