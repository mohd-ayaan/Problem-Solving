class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int[] arr;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){continue;} 
            
            arr = Arrays.copyOf(nums, n);
            boolean dir=false;   // false->left
            int j=i;
            while(j>=0 && j<n){
                if(arr[j]>0){
                    arr[j]-=1;
                    dir=!dir;
                }
                j=(dir==false)?j-1:j+1;
                
            }
            boolean zero=true;
            for(int k=0;k<n;k++){
                // System.out.print(arr[k]+" ");
                if(arr[k]!=0){
                    zero=false;
                    break;
                }
            }
            if(zero){cnt+=1;}
            System.out.println("\ni: "+i+" left, cnt: "+cnt);



            dir=true;    //true ->right
            j=i;
            arr = Arrays.copyOf(nums, n);   
            while(j>=0 && j<n){
                if(arr[j]>0){
                    arr[j]-=1;
                    dir=!dir;
                }
                j=dir==false?j-1:j+1;
            }
            zero=true;
            for(int k=0;k<n;k++){
                if(arr[k]!=0){
                    zero=false;
                    break;
                }
            }
            if(zero){cnt+=1;}
            System.out.println("i: "+i+", right, cnt: "+cnt);
        }
        return cnt;
    }
}