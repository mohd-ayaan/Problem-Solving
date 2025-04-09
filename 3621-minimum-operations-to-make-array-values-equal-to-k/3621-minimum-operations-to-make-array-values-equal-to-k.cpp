class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int minval=*min_element(nums.begin(),nums.end());
        unordered_set<int> distinctNumbers(nums.begin(), nums.end());
        int n=distinctNumbers.size();
        cout<<minval<<endl;
        if(k==minval){return n-1;}
        if(k<minval){return n;}
        return -1;
    }
};