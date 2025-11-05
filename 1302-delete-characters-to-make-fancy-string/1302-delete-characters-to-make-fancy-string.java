class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        int cnt=1;
        Character c,pre;
        for(int i=1;i<n;i++){
            c=s.charAt(i);
            pre=s.charAt(i-1);
            if(c==pre){
                cnt+=1;
            }
            else if(c!=pre){
                cnt=1;
            }

            if(cnt>=3){
                continue;
            }
            sb.append(c);    
 
        }
        return sb.toString();
    }
}