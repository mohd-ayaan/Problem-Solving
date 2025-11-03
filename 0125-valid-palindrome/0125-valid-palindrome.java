class Solution {
    public boolean isPalindrome(String s) {
        String str=s.toLowerCase();
        StringBuilder sb=new StringBuilder();

        for(Character c:str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        // System.out.println(sb);
        StringBuilder reversesb= new StringBuilder(sb).reverse();
        // System.out.println(reversesb);
        if(sb.toString().equals(reversesb.toString())){return true;}
        return false;
    }
}