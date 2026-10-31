class Solution {
    //Recursion:  O(2^m+n)
    // public int Memoize(int[][] grid, int m, int n, int i, int j){
    //     if(i<0 || j<0)return Integer.MAX_VALUE;
    //     if(i==0 && j==0)return grid[0][0];

    //     //top row
    //     int left=Memoize(grid,m,n,i,j-1);
    //     if(i==0) return grid[i][j]+left;

    //     //left column
    //     int top=Memoize(grid,m,n,i-1,j);
    //     if(j==0) return grid[i][j]+top;
        
    //     System.out.println("("+i+","+j+"): "+"⬅" + left + " ⬆" + top);
    //     return grid[i][j]+Math.min(left,top);
    // }
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;

    //     return Memoize(grid,m,n,m-1,n-1);
    // }


    //Memoization: Time-O(m+n), space-O(m*n)
    // public int Memoize(int[][] grid, int m, int n, int i, int j, int[][] memo){
    //     if(i<0 || j<0)return Integer.MAX_VALUE;
    //     if(memo[i][j]!=-1) return memo[i][j];
    //     if(i==0 && j==0)return memo[i][j]=grid[0][0];
        

    //     int left=Memoize(grid,m,n,i,j-1,memo);
    //     int top=Memoize(grid,m,n,i-1,j,memo);
        
    //     return memo[i][j]=grid[i][j]+Math.min(left,top);
    // }
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int[][] memo=new int[m][n];

    //     for(int i=0;i<m;i++){
    //         Arrays.fill(memo[i],-1);
    //     }

    //     Memoize(grid,m,n,m-1,n-1,memo);
    //     return memo[m-1][n-1];
    // }

    //Tabulation: Time-O(m*n), space-O(m*n)
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int[][] memo=new int[m][n];
    //     memo[0][0]=grid[0][0];

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i==0 && j==0)continue;

    //             if(j==0){memo[i][j]=grid[i][j]+memo[i-1][j];}
    //             else if(i==0){memo[i][j]=grid[i][j]+memo[i][j-1];}
    //             else{
    //                 memo[i][j]=grid[i][j]+Math.min(memo[i][j-1],memo[i-1][j]);
    //             }
    //         }
    //     }
    //     return memo[m-1][n-1];
    // }

    //Space Optimized: Time-O(m*n), space(2 rows prev and curr having total 2n columns)-O(2n)
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        prev[0]=grid[0][0];

        for(int j=1;j<n;j++){
            prev[j]=grid[0][j]+prev[j-1];
        }

        for(int i=1;i<m;i++){
            int[] curr=new int[n];
            curr[0]=grid[i][0]+prev[0];
            for(int j=1;j<n;j++){
                curr[j]=grid[i][j]+Math.min(curr[j-1],prev[j]);
            }

            prev=curr;

        }
        return prev[n-1];
    }
}