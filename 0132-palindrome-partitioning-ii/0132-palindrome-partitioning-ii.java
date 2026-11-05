class Solution {
    // public boolean isPalindrome(String s, int i, int j){
    //     if(i==j)return true;
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j))return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    // public int recursion(String s, int i){
    //     if(i==s.length())return 0;

    //     int ans=Integer.MAX_VALUE;
    //     for(int j=i;j<s.length();j++){
    //         if(isPalindrome(s,i,j)){
    //             ans=Math.min(ans,1+recursion(s,j+1));
    //         }
    //     }
    //     return ans;
    // }
    // public int minCut(String s) {
    //     return recursion(s,0)-1;
    // }

    public boolean isPalindrome(String s, int i, int j){
        if(i==j)return true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public int recursion(String s, int i,int[] dp){
        if(i==s.length())return 0;
        if(dp[i]!=-1)return dp[i];

        int ans=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                ans=Math.min(ans,1+recursion(s,j+1,dp));
            }
        }
        return dp[i]=ans;
    }
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return recursion(s,0,dp)-1;
    }
}