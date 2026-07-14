class Solution {
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
                // Need to split nums[i] into k parts
                long k = (nums[i] + prev - 1) / prev; // ceil(nums[i] / prev)
                ans += k - 1; // replacements count
                prev = nums[i] / k; // new max part size
            }
        }
        
        return ans;
    }
}
