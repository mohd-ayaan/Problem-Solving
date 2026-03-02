class Solution {
    //O(n+m)
    public int appendCharacters(String s, String t) {
        int n=s.length(), m=t.length();
        int count=0;
        int i=0,j=0;
        while(j<m){
            char c=t.charAt(j);
            while(i<n && c!=s.charAt(i)){
                i++;
            }
            if(i>=n){return m-count;}
            count++;
            
            j++;
            i++;
        }
        return m-count;
    }
}