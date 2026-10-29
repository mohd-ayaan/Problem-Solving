class Solution {
    //Recursive: O(branch^depth) : O(coins.length ^ amount)
    //Memoization / Tabulation: O(coins.length * amount)
    // public int coinChange(int[] coins, int amount) {
    //     int[] memo=new int[amount+1];
    //     Arrays.fill(memo,-2);

    //     return Memoize(coins, amount, memo);
    // }
    // public int Memoize(int[] coins, int amount, int[] memo){
    //     if(amount==0)return 0;
    //     if(amount<0)return -1;
    //     if(memo[amount]!=-2) return memo[amount]; 

    //     int coinsUsed=Integer.MAX_VALUE;
    //     for(int coin:coins){
    //         int res=Memoize(coins,amount-coin,memo);
    //         if(res>=0 && res<coinsUsed){
    //             coinsUsed=1+res;
    //         }
    //     }
    //     memo[amount]=coinsUsed!=Integer.MAX_VALUE?coinsUsed:-1;
    //     return memo[amount];
    // }

    public int coinChange(int[] coins, int amount) {
        int[] memo=new int[amount+1];
        Arrays.fill(memo,-2);
        memo[0]=0;

        for(int i=1;i<=amount;i++){
            int coinsUsed=Integer.MAX_VALUE;
            for(int coin:coins){
                int rem=i-coin;
                if(rem>=0 && memo[rem]>=0){
                    coinsUsed=Math.min(coinsUsed,memo[rem]+1);
                }
            }

            memo[i]=coinsUsed!=Integer.MAX_VALUE?coinsUsed:-1;
        }
        return memo[amount];
    }
}