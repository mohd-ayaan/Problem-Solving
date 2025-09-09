class Solution {
    // TC:O(n), SC:O(n)
    // public int firstMissingPositive(int[] nums) {
    //     HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
    //     for(int i=0;i<nums.length;i++){
    //         hs.put(nums[i],1);
    //     }
    //     for(int i=1;i<nums.length+1;i++){
    //         if(hs.containsKey(i)==false){
    //             return i;
    //         }
    //     }
    //     return nums.length + 1;
    // }


    // TC:O(n), SC:O(1)
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i] - 1]){
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){return i+1;}
        }
        return n +1;
    }
}