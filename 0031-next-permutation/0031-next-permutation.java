class Solution {
    public void swap(int[] nums, int start){
        int t,end=nums.length-1;
        while(start<end){
            t=nums[start];
            nums[start]=nums[end];
            nums[end]=t;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1)return;

        //Find pivot
        int pivot=n-2;
        while(pivot>=0 && nums[pivot]>=nums[pivot+1]){pivot--;}

        //Find successor
        
        if(pivot!=0){
            int successor=n-1;
            while(nums[successor]<=nums[pivot]){successor--;}

            //swap pivot and successor
            int t=nums[pivot];
            nums[pivot]=nums[successor];
            nums[successor]=t;
        }

        

        //Reverse suffix
        swap(nums,pivot+1);
    }
}