class Solution {
public:
    vector<int> buildArray(vector<int>& nums) {
        unordered_map<int,int> mp;
        for(int i=0;i<nums.size();i++){
            if(mp.find(nums[i])!=mp.end()){
                mp[i]=nums[i];
                nums[i]=mp[nums[i]];
            }
            else{
                mp[i]=nums[i];
                nums[i]=nums[nums[i]];
            }
        }
        return nums;
    }
};