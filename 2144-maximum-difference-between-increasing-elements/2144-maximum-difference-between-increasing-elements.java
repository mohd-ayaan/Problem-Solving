class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int maxdiff=-1;
        int i=0;
        for(int j=1;j<n;j++){
            if(nums[i]!=nums[j]){
                maxdiff=Math.max(maxdiff,nums[j]-nums[i]);
            }

            if(nums[j]<nums[i]){i=j;}
        }
        return maxdiff;
    }
}