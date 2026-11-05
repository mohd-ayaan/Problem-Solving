class Solution {
    int Mod=1_000_000_007;
    public long Recursion(int[] locations, int current, int finish, int fuel, long[][] dp){
        if(fuel<0 )return 0;
        if(dp[current][fuel]!=-1)return dp[current][fuel];

        long ways=current==finish?1:0;
        for(int city=0;city<locations.length;city++){
            if(city==current){continue;}
            
            int cost=Math.abs(locations[city]-locations[current]);
            ways=(ways+Recursion(locations,city,finish,fuel-cost,dp))%Mod;
            
        }
        return dp[current][fuel] = ways;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp=new long[locations.length][fuel+1];
        for(long[] row:dp){Arrays.fill(row,-1);}
        return (int)Recursion(locations, start,finish,fuel,dp);
    }
}