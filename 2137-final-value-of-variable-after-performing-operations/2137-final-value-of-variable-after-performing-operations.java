class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n=operations.length;
        int X=0;
        for(String str:operations){
            if(str.indexOf("--")!=-1){
                X-=1;
            }
            else{
                X+=1;
            }
        }
        return X;
    }
}