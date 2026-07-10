class Solution {
    // O(N)-time and space(string builder)
    public String largestOddNumber(String num) {
        int len=num.length();
        int ind=-1;

        for(int i=len-1;i>=0;i--){    
            // if(num.charAt(i)%2!=0)   implicit type casting is done,'0'->48, so logic technically works only by coincidence.
            // corrent is defined below by 2 ways:
            // if (Character.getNumericValue(num.charAt(i)) % 2 != 0)

            if((num.charAt(i)-'0')%2!=0){
                ind=i;
                break;
            }
        }
        if(ind==-1)return "";
        StringBuilder sb=new StringBuilder(num.substring(0,ind+1));
        return sb.toString();

    }
}