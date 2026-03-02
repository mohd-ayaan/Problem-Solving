class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n=nums.size();
        int res=0;

        if(n==1){return res;}

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums.get(i)+nums.get(j)<target){res++;}
            }
            
        }
        return res;
        
    }
}