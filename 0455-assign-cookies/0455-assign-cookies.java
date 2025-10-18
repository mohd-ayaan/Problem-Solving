class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gs=g.length,ss=s.length;
        Arrays.sort(s);
        Arrays.sort(g);
        int l=0,r=0;
        
        while(l<ss && r<gs){
            if(s[l] >= g[r]){
                r+=1;
            }
            l+=1;
        }
        return r;
    }
}