class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if(n==1){return 1;}
        int res=0;
        int[] LtoR=new int[n];
        int[] RtoL=new int[n];

        int increment=1;
        LtoR[0]=increment;
        RtoL[n-1]=increment;

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){increment++;}
            else{increment=1;}

            LtoR[i]=increment;
        }

        increment=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){increment++;}
            else{increment=1;}

            RtoL[i]=increment;
        }

        for(int i=0;i<n;i++){
            res+=Math.max(LtoR[i],RtoL[i]);
        }

        return res;
    }
}