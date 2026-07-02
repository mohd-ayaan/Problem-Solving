class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;

        for(int i=n/2-1;i>=0;i--){
            maxHeapify(nums,n,i);
        }

        for(int i=n-1;i>0;i--){
            int swap=nums[i];
            nums[i]=nums[0];
            nums[0]=swap;

            maxHeapify(nums,i,0);
        }
        return nums;
    }

    public void maxHeapify(int[] nums, int n, int ind){
        int largest=ind;
        int left=2*largest+1;
        int right=2*largest+2;

        if(left<n && nums[left]>nums[largest]){
            largest=left;
        }

        if(right<n && nums[right]>nums[largest]){
            largest=right;
        }

        if(largest!=ind){
            int swap=nums[largest];
            nums[largest]=nums[ind];
            nums[ind]=swap;

            maxHeapify(nums,n,largest);
        }
    }
}