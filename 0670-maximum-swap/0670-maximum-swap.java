class Solution {
    public int maximumSwap(int num) {
        int len=0;
        int n=num;
        while(n>0){
            len++;
            n/=10;
        }
        if(len<2)return num;

        n=num;
        for(int i=0;i<len-1;i++){
            num=swap(num,i,len);
            if(n!=num)return num;
        }
        return num;
    }
    public int swap(int num, int ind, int len){
        int largest=ind;
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        for(int i=len-1;i>=ind;i--){
            if(sb.charAt(i)>sb.charAt(largest)){largest=i;}
        }

        if(ind==largest){return num;}

        char t=sb.charAt(largest);
        sb.setCharAt(largest,sb.charAt(ind));
        sb.setCharAt(ind,t);

        return Integer.parseInt(sb.toString());
    }

}