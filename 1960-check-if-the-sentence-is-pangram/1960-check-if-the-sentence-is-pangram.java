class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> s=new HashSet<>();
        for(char c: sentence.toLowerCase().toCharArray()){
            if(Character.isLetter(c)){s.add(c);}
        }
        return s.size()==26;

    }
}