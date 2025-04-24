class Solution {
public:
    int findMin(vector<int>& nums) {
        int l=0, n=nums.size();
        int h=n-1;

        while(l<h){
            int mid=(l+h)/2;
            cout<<nums[mid]<<" ";
        
            if(nums[mid]>nums[h]){
                l=mid+1;
            }
            
            else{
                h=mid;
            }
         
        }
        return nums[l];
    }
};