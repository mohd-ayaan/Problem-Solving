class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
    const int MOD = 1000000007;
    int n = arr.size();
    
    // Kadane's algorithm for one copy
    int maxSum = 0, currentSum = 0;
    for (int num : arr) {
        currentSum = max(0, currentSum + num);
        maxSum = max(maxSum, currentSum);
    }
    
    if (k == 1) return maxSum % MOD;
    
    // Total sum of the array
    long totalSum = 0;
    for (int num : arr) totalSum += num;

    // Kadane's algorithm for two copies
    int maxTwoCopySum = 0;
    currentSum = 0;
    for (int i = 0; i < 2 * n; i++) {
        currentSum = max(0, currentSum + arr[i % n]);
        maxTwoCopySum = max(maxTwoCopySum, currentSum);
    }

     cout << "maxTwoCopySum: " << maxTwoCopySum << endl;
    cout << "totalSum: " << totalSum <<endl;
    // Final result
    if (totalSum > 0) {
        return max((int)maxTwoCopySum,(int) (maxTwoCopySum + (k - 2) * totalSum % MOD)) % MOD;
    } else {
        return (int)maxTwoCopySum % MOD;
    }
}
};