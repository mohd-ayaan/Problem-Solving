class Solution {
    private void divideby2(StringBuilder sb){
        int n=sb.length();
        sb.deleteCharAt(n-1);
    }
    private void add1(StringBuilder sb){
        int i=sb.length()-1;

        while(i>=0 && sb.charAt(i)=='1'){
            sb.setCharAt(i,'0');
            i--;
        }
        if(i<0){
            sb.insert(0,'1');
        }
        else{
            sb.setCharAt(i,'1');
        }

    }
    public int numSteps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int operations=0;
        

        while(sb.length()>1){
            int n=sb.length(); 

            if(sb.charAt(n-1)=='0'){
                divideby2(sb);
            }
            else{
                add1(sb);
                
            }
            operations++;
        }
        return operations;
    }
}