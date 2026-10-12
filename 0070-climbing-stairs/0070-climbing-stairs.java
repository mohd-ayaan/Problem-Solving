class Solution {
    //Recursive-O(n), stack space-O(n)
    // public int recursive(int n){
    //     if(n<2)return 1;

    //     return recursive(n-1)+recursive(n-2);
    // }
    // public int climbStairs(int n) {
    //     if(n==1)return 1;
    //     return recursive(n-1,1,1)+recursive(n-2);
    // }

    // Iterative: time O(n), space-O(1)
     public int climbStairs(int n) {
        if(n==1)return 1;
        int current, prev1=1, prev2=1;

        for(int i=2;i<=n;i++){
            current=prev1+prev2;
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
    
}