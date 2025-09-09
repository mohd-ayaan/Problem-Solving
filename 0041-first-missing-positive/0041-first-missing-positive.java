class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],1);
        }
        for(int i=1;i<nums.length+1;i++){
            if(hs.containsKey(i)==false){
                return i;
            }
        }
        return nums.length + 1;
    }
}