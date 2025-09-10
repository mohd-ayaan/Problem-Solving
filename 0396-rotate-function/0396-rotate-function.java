class Solution {
    // TC:O(n), SC:O(1)
    public int maxRotateFunction(int[] nums) {
        int currval=0;
        int sum=0, n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            currval+=(i*nums[i]);
        }
        int maxval=currval;
        for(int i=1;i<=n;i++){
            currval=(currval+sum)-(n*nums[n-i]);
            if(currval>maxval){maxval=currval;}
        }
        return maxval;
    }
}