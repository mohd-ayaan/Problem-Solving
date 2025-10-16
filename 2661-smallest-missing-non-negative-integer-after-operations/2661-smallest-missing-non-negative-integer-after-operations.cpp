class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
    unordered_map<int, int> freq;
    for (int num : nums) {
        int rem = ((num % value) + value) % value;
        freq[rem]++;
    }

    int mex = 0;
    while (true) {
        int rem = mex % value;
        if (freq[rem] > 0) {
            freq[rem]--;
            mex++;
        } else {
            break;
        }
    }
    return mex;
}

};