class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxreach=0, maxind=0;
        for(int i=0;i<n-1;i++){
            maxind=(nums[i]!=0)?i+nums[i]:maxind;
            // System.out.println(i+" "+maxind);
            maxreach=Math.max(maxreach,maxind);
        }
        if(maxreach>=(n-1)){return true;}
        return false;
    }
}