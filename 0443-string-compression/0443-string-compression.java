class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0,j=0;
        int count;
        StringBuilder sb=new StringBuilder();
        while(i<n && j<n){
            i=j;
            count=0;
            char c=chars[i];
            while(j<n && chars[i]==chars[j]){
                j++;
                count++;
            }
            sb.append(c);
            if(count!=1){
                String str=String.valueOf(count);
                for(char ch:str.toCharArray()){
                    sb.append(ch);
                }
                
            }    
        }

        i=0;
        for(char c:sb.toString().toCharArray()){
            chars[i]=c;
            i++;
        }
        return sb.length();
    }
}