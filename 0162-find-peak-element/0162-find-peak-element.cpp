class Solution {
public:
    int findPeakElement(vector<int>& nums) {
            int  n=nums.size();
            int l=1,h=n-2;
            if(n==1){return 0;}
            if(nums[0]>nums[1]){return 0;}
            if(nums[n-1]>nums[n-2]){return n-1;}
            int res=-1;
    
            while(l<=h){
                int mid=(l+h)/2;  
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                    res=mid;
                    return res;
                }
              
                else if(nums[mid]>nums[mid-1]){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
             
            }
            return res;
    }

};