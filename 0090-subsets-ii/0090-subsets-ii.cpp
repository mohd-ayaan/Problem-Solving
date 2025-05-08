class Solution {
public:
    void backtrack(vector<int>& nums, int start,vector<int>& subset, vector<vector<int>>& powerset){
        powerset.push_back(subset);
        
        for(int i = start; i < nums.size(); i++){
            if(i > start && nums[i] == nums[i-1]) continue; 
            
            subset.push_back(nums[i]);
            backtrack(nums, i+1,subset,powerset);
            
            subset.pop_back();
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> powerset;
        vector<int> subset;
        sort(nums.begin(), nums.end()); 
        
        backtrack(nums, 0,subset,powerset);
        return powerset;
    }

};