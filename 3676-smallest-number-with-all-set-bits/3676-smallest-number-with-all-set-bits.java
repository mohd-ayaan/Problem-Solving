class Solution {
    public int smallestNumber(int n) {
        int num=0, i=0;
        while(num<n){
           num+=Math.pow(2,i++);
        } 
        return num;
    }
}