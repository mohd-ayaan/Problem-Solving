class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int  n=nums.size();
        int l=1,h=n-2;
        if(n==1){return nums[0];}
        if(nums[0]!=nums[1]){return nums[0];}
        if(nums[n-1]!=nums[n-2]){return nums[n-1];}
        int res=nums[0];

        while(l<=h){
            int mid=(l+h)/2;  
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                res=nums[mid];
                return res;
            }
            // 1st is at even, 2nd at odd. but when single element appears, this fails.
            // even(m-1),odd(m)->element is on right half.
            // odd(m-1),even(m)->element is on left half.

            //  E O E O E O E O E 
            // [1,1,2,3,3,4,4,8,8]
            //    l #   M     H  
            //   
            else if((mid%2==0 && nums[mid-1]==nums[mid]) || (mid%2==1 && nums[mid+1]==nums[mid])){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
         
        }
        return res;
    }
};
