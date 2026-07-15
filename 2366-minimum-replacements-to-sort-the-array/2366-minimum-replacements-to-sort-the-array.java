class Solution {
    //TC: O(N) time, O(1) space
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans = 0;
        
        // Start from the last element
        long prev = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= prev) {
                // Already fits the sorted order
                prev = nums[i];
            } else {
                // Need to split nums[i] into parts
                //Ex.[...,13,4], 13-> 4,4,4,1. Here ceil(13/4) gives 4 parts. the parts into we have to divide number as per min previosly found.
                long parts = (nums[i] + prev - 1) / prev;

                //operations to break a num in k parts is (parts-1)
                ans += parts - 1; 

                //13->4,4,4,1 is wrong, 13->4,3,3,3 is rignt.
                //to find max of min values, do num/parts. 
                prev = nums[i] / parts;
            }
        }
        
        return ans;
    }
}
