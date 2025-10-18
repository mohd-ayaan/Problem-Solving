class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int distinctcnt=0, demand=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int lower_bound=nums[i]-k;
            int upper_bound=nums[i]+k;

            if(demand<lower_bound){
                demand=lower_bound;
                distinctcnt+=1;
            }
            else if(demand< upper_bound){
                demand+=1;
                distinctcnt+=1;
            }
        } 
        return distinctcnt;
    }
}