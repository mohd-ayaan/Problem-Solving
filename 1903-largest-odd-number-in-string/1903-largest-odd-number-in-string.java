class Solution {
    public String largestOddNumber(String num) {
        int len=num.length();
        int ind=-1;

        for(int i=len-1;i>=0;i--){
            if(num.charAt(i)%2!=0){
                ind=i;
                break;
            }
        }
        if(ind==-1)return "";
        StringBuilder sb=new StringBuilder(num.substring(0,ind+1));
        return sb.toString();

    }
}