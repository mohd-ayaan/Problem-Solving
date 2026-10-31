class Solution {
    // public int Recursion(int[] nums, int n, int curr, int prev){
    //     if(curr==n)return 0;

    //     // cannot take current
    //     if(prev!=-1 && nums[curr]<=nums[prev])return Recursion(nums,n,curr+1,prev);

    //     // take or not take
    //     return Math.max(Recursion(nums,n,curr+1,prev),1+Recursion(nums,n,curr+1,curr));
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int n=nums.length;
    //     return Recursion(nums,n,0,-1);
    // }

    public int Memoization(int[] nums, int n, int curr, int prev,int[][] dp){
        if(curr==n)return 0;
        if(dp[curr][prev+1]!=-1)return dp[curr][prev+1];

        // cannot take current
        if(prev!=-1 && nums[curr]<=nums[prev])return dp[curr][prev+1]=Memoization(nums,n,curr+1,prev,dp);

        // take or not take
        return dp[curr][prev+1]=Math.max(Memoization(nums,n,curr+1,prev,dp),1+Memoization(nums,n,curr+1,curr,dp));
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        Memoization(nums,n,0,-1,dp);
        // System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}