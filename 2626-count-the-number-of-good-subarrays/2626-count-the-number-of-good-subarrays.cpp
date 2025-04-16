class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        int n = nums.size();
        long long count = 0;
        unordered_map<int, int> freq;
        int pairs = 0;
        int l = 0;
    
        for (int r = 0; r < n; r++) {
            pairs += freq[nums[r]];
            freq[nums[r]]++;
    
            while (pairs >= k) {
                count += n - r;
                pairs -= --freq[nums[l]];
                l++;
            }
        }
        return count;
    }
};