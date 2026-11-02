class Solution {
    // Recursive: time:O(2^n) 
    // public int Recursion(int[] nums, int n, int curr, int prev){
    //     if(curr==n)return 0;

    //     // dont take
    //     int not_take= Recursion(nums,n,curr+1,prev);

    //     // take if valid(valid can be in 2 ways, either first chosed element or greater than prev)
    //     int take=0;
    //     if(prev==-1 || nums[curr]>nums[prev]){
    //         take=1+Recursion(nums,n,curr+1,curr);
    //     }
    //     return Math.max(not_take,take);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int n=nums.length;
    //     return Recursion(nums,n,0,-1);
    // }

    // Memorization: time O(n^2) 
    // public int Memoization(int[] nums, int n, int curr, int prev,int[][] dp){
    //     if(curr==n)return 0;
    //     if(dp[curr][prev+1]!=-1)return dp[curr][prev+1];

    //     int not_take= Memoization(nums,n,curr+1,prev,dp);

    //     int take=0;
    //     if(prev==-1 || nums[curr]>nums[prev]){
    //         take=1+Memoization(nums,n,curr+1,curr,dp);
    //     }
    //     return dp[curr][prev+1]=Math.max(not_take,take);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int n=nums.length;
    //     int[][] dp=new int[n+1][n+1];
    //     for(int i=0;i<=n;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return Memoization(nums,n,0,-1,dp);
    // }

    // Tabulation: Time-O(n^2), space(1D)-O(n)
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        
        Arrays.fill(dp,1);
        
        // Every element of the `nums` is a subsequence of length 1. 
        int LIS=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            LIS=Math.max(LIS,dp[i]);
        }

        return LIS;
    }
}