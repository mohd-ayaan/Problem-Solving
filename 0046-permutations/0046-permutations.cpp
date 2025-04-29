class Solution {
public:
    void generatePermutations(vector<int>& nums, int index, vector<vector<int>>& result) {
    // Base case: If index reaches the end, add the current array to the result
    if (index == nums.size()) {
        result.push_back(nums);
        return;
    }

    // Recursive case: Swap and generate permutations
    for (int i = index; i < nums.size(); i++) {
        // Swap current index with i
        swap(nums[index], nums[i]);
        // Recur for the next index
        generatePermutations(nums, index + 1, result);
        // Backtrack: Swap back to restore the array
        swap(nums[index], nums[i]);
    }
}
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        generatePermutations(nums,0,res);
        return res;
    }
};