class Solution {
public:
    void dfs(vector<int>& candidates, int target, int ind, int sum, vector<int>& subset, vector<vector<int>>& res){
        if(ind>=candidates.size() || sum>target){return;}
        if(sum==target){
            res.push_back(subset);
            return;
        }
        subset.push_back(candidates[ind]);
        dfs(candidates,target,ind,sum+candidates[ind],subset,res);
        subset.pop_back();
        dfs(candidates,target,ind+1,sum,subset,res);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> subset; 
        vector<vector<int>> res;
        dfs(candidates,target,0,0,subset,res);
        return res; 
    }
};