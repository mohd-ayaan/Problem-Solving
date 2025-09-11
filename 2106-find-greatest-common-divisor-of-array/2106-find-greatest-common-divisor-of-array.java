class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        int smallest=nums[0], largest=nums[0];
        for(int i=1;i<n;i++){
            smallest=Math.min(smallest,nums[i]);
            largest=Math.max(largest,nums[i]);
        }
        return GCD(largest,smallest);
    }
    private int GCD(int a, int b){
        if(b==0){return a;}
        else{
            return GCD(b,a%b);
        }
    }
}