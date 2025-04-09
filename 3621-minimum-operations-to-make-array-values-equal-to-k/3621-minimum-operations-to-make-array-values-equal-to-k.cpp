class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int minval=nums[0];
        int n=1, lastele=nums[0];
        for(int i=1;i<nums.size();i++){
            if(nums[i]!=lastele){
                lastele=nums[i];
                n+=1;
            }
        }
        cout<<minval<<endl;
        if(k==minval){return n-1;}
        if(k<minval){return n;}
        return -1;
    }
};