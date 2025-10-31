class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> st=new HashSet<>();
        int[] res=new int[2];
        int n=nums.length, j=0;
        
        for(int i=0;i<n;i++){
            if(st.contains(nums[i])){
                res[j++]=nums[i];
            }
            else{
                st.add(nums[i]);
            }
        }
        return res;
    }
}