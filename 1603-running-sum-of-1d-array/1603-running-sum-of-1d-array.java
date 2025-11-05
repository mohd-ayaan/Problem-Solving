class Solution {
    public int[] runningSum(int[] nums) {
        int sum=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            sum+=nums[i];
            nums[i]=sum;
        }
        return nums;
    }
}