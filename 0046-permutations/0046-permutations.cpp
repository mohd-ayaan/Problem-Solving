class Solution {
public:
    void DFS(vector<int>& nums, vector<vector<int>>& res, unordered_set<int>& visited, vector<int>& subset){
        if(subset.size()==nums.size()){
            res.push_back(subset);
        }
        for(int i=0;i<nums.size();i++){
            if(visited.find(i)==visited.end()){
                visited.insert(i);
                subset.push_back(nums[i]);
                DFS(nums,res,visited,subset);
                subset.pop_back();
                visited.erase(i);
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> subset;
        unordered_set<int> visited;
        DFS(nums,res,visited,subset);
        return res;
    }
};