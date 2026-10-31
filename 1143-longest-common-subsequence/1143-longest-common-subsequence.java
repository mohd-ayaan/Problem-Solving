class Solution {
    // Rexursion: Time-O(2^l1+l2)
    // public int Recursion(String text1, String text2, int l1, int l2, int i, int j){
    //     if(i<0 || j<0)return 0;

    //     if(text1.charAt(i)==text2.charAt(j))return 1+Recursion(text1,text2,l1,l2,i-1,j-1);
    //     return Math.max(Recursion(text1,text2,l1,l2,i-1,j),Recursion(text1,text2,l1,l2,i,j-1));
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int l1=text1.length();
    //     int l2=text2.length();

    //     return Recursion(text1,text2,l1,l2,l1-1,l2-1);
    // }

    //Memoization(top-down): time- O(l1*l1), space-O(l1*l2)
    // public int Recursion(String text1, String text2, int l1, int l2, int i, int j, int[][] dp){
    //     if(i<0 || j<0)return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];


    //     if(text1.charAt(i)==text2.charAt(j)) dp[i][j]=1+Recursion(text1,text2,l1,l2,i-1,j-1,dp);
    //     else{dp[i][j]=Math.max(Recursion(text1,text2,l1,l2,i-1,j,dp),Recursion(text1,text2,l1,l2,i,j-1,dp));}
    //     return dp[i][j];
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int l1=text1.length();
    //     int l2=text2.length();
    //     int[][] dp=new int[l1][l2];
    //     for(int i=0;i<l1;i++){Arrays.fill(dp[i],-1);}

    //     Recursion(text1,text2,l1,l2,l1-1,l2-1,dp);
    //     return dp[l1-1][l2-1];
    // }

    //Tabulation: time- O(l1*l2), space-O(l1*l2)
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int l1=text1.length();
    //     int l2=text2.length();
    //     int[][] dp=new int[l1][l2];


    //     dp[0][0]=text1.charAt(0)==text2.charAt(0)?1:0;
    //     for(int j=1;j<l2;j++){
    //         if(text1.charAt(0)==text2.charAt(j)) dp[0][j]=Math.max(1,dp[0][j-1]);
    //         else{dp[0][j]=Math.max(0,dp[0][j-1]);}
    //     }

    //     for(int i=1;i<l1;i++){
    //         if(text1.charAt(i)==text2.charAt(0)) dp[i][0]=Math.max(1,dp[i-1][0]);
    //         else{dp[i][0]=Math.max(0,dp[i-1][0]);}

    //         for(int j=1;j<l2;j++){
    //             if(text1.charAt(i)==text2.charAt(j)) dp[i][j]=1+dp[i-1][j-1];
    //             else{dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);}
    //         }
    //     }
    //     return dp[l1-1][l2-1];
    // }

    //Space Optimezed: time- O(l1*l2), space-O(2*l2)
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int[] prev=new int[l2];

        //first row 
        prev[0]=text1.charAt(0)==text2.charAt(0)?1:0;
        for(int j=1;j<l2;j++){
            if(text1.charAt(0)==text2.charAt(j)) prev[j]=1;
            else{prev[j]=Math.max(0,prev[j-1]);}
        }

        for(int i=1;i<l1;i++){
            int[] curr=new int[l2];
            //first column
            if(text1.charAt(i)==text2.charAt(0)) curr[0]=1;
            else{curr[0]=Math.max(0,prev[0]);}

            //rest of cells
            for(int j=1;j<l2;j++){
                if(text1.charAt(i)==text2.charAt(j)) curr[j]=1+prev[j-1];
                else{curr[j]=Math.max(prev[j],curr[j-1]);}
            }
            prev=curr;
        }
        return prev[l2-1];
    }

}