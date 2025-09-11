class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a,b;
        for(int i=1;i<=n;i++){
            a=i;
            b=n-i;
            if(ContainsZero(a) && ContainsZero(b)){
                return new int[]{a,b};
            }

        }
       return new int[]{-1,-1};
    }

    private boolean ContainsZero(int num){
        if(num==0){return false;}

        int n=num;
        while(n>0){
            if(n%10==0){return false;}
            n/=10;
        }
        return true;
    }
}