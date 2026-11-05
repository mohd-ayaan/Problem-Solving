class Solution {
    //Recursion: Number of recursive states explored = n and palindrome check take O(n). So, Time = O(2^n · n)
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

    //Memoization: for each DP index we are running a for loop from `j = i` to `n` and a palindromic check. TC - O(n³)
    // public boolean isPalindrome(String s, int i, int j){
    //     if(i==j)return true;
    //     while(i<j){
    //         if(s.charAt(i)!=s.charAt(j))return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    // public int recursion(String s, int i,int[] dp){
    //     if(i==s.length())return 0;
    //     if(dp[i]!=-1)return dp[i];

    //     int ans=Integer.MAX_VALUE;
    //     for(int j=i;j<s.length();j++){
    //         if(isPalindrome(s,i,j)){
    //             ans=Math.min(ans,1+recursion(s,j+1,dp));
    //         }
    //     }

    //     return dp[i]=ans;
    // }
    // public int minCut(String s) {
    //     // minimum partitions needed from i till end
    //     int[] dp=new int[s.length()];
    //     Arrays.fill(dp,-1);
    //     return recursion(s,0,dp)-1;
    // }


    // Tabulation with pre-compute 2D palindrome table of O(1) lookup-O(n^2) and 2 for loops for DP buildup - O(n^2)
    // TC- O(n^2)
    public int minCut(String s) {
        int n=s.length();

        // create palindrome table for O(1) lookup
        boolean[][] pal=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    // if o to 1 characters are between i and j
                    if(j-i<=2)pal[i][j]=true;
                    //else with char i==char j, look for elements beween i and j
                    else{
                        pal[i][j]=pal[i+1][j-1];
                    }
                }
            }
        }

        // dp[i] means minimum partitions needed from i till end
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int ans=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){   
                if(pal[i][j]){
                    ans=Math.min(ans,1+dp[j+1]);
                }
            }
            dp[i]=ans;
        }

        // cuts=(total partitions from index 0 to end) -1
        return dp[0]-1;
    }
}