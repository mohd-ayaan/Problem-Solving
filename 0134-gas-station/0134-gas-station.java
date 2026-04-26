class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int tank=0,total=0,start=0;
        for(int i=0;i<n;i++){
            int diff=gas[i]-cost[i];
            total+=diff;
            tank+=diff;
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }
        return total>=0?start:-1;
    }
}