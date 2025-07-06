class Solution {
public:
    bool possible(vector<int>& nums, int divisor, int threshold){
        int sum=0;
        int n=nums.size();
        for(int i=0;i<n;i++){
            // sum+=ceil(nums[i]/divisor);
            sum += (nums[i] + divisor - 1) / divisor; //ceil function

        }
        return sum<=threshold?1:0;

    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        int l=1;
        int h=*max_element(nums.begin(),nums.end());

        int res=-1;
        while(l<=h){
            int divisor=(l+h)/2;
            if(possible(nums,divisor,threshold)){
                res=divisor;
                h=divisor-1;
            }
            else{
                l=divisor+1;
            }
        }
        return res;
    }
    
};