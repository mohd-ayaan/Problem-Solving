class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        int res=0;
        if(m==0){return res;}

        Arrays.sort(g);
        Arrays.sort(s);

        int greedInd=0;
        int sizeInd=0;
        while(greedInd<n){
            if(sizeInd>=m){break;}
            else if(g[greedInd]>s[sizeInd]){
                sizeInd++;
                continue;
            }
            else{
                res++;
                sizeInd++;
                greedInd++;
            }
        }
        return res;
    }
}