class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);

        int past2=nums[0], past1=Math.max(nums[0],nums[1]);
        int store;

        for(int i=2;i<n;i++){
            store=past1;
            past1=Math.max(past1,past2+nums[i]);
            past2=store;
        }
        return past1;

        
    }
}