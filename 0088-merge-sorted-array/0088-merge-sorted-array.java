class Solution {
    //Time-O(m+n),space=O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        while(i<m){
            minheap.offer(nums1[i]);
            i++;
        }
        while(j<n){
            minheap.offer(nums2[j]);
            j++;
        }
        while(!minheap.isEmpty() && k<m+n){
            nums1[k]=minheap.poll();
            k++;
        }

        
    }
}