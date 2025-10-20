class Solution {
    // TLE, O(n^n)
    // public int backtrack(int[] nums, int ind, int jump){
    //     if(ind>=nums.length-1){return jump;}

    //     int minjump=Integer.MAX_VALUE;
    //     for(int i=1;i<=nums[ind];i++){
    //        if(ind + i < nums.length){
    //             minjump = Math.min(minjump, backtrack(nums, ind + i, jump + 1));
    //         }
    //     }
    //     return minjump;
    // }
    // public int jump(int[] nums) {
    //     return backtrack(nums,0,0);
    // }

    
    public int jump(int[] nums) {
        int n=nums.length, l=0, r=0,jump=0;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            l=r+1;
            r=farthest;
            jump++;
        }
        return jump;

    }
}