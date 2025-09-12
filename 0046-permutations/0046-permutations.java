class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        generatepermute(nums,0,nums.length-1,ls);
        return ls;

    }
    private  void generatepermute(int[] nums,int ind,int end,List<List<Integer>> ls){
        if(ind==end){
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            ls.add(perm);
            return;
        }
        for(int i=ind;i<=end;i++){
            swap(nums,ind,i);
            generatepermute(nums,ind+1,end,ls);
            swap(nums,ind,i);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}