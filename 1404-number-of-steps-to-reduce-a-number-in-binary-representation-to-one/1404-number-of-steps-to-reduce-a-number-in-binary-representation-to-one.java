class Solution {
    // TC-O(N), SC-O(1)
    public int numSteps(String s) {
        int n=s.length();
        int carry=0, operations=0;
        for(int i=n-1;i>0;i--){
            int digit=Character.getNumericValue(s.charAt(i))+carry;

            if(digit%2==1){
                operations+=2;
                carry=1;
            }
            else{
                operations+=1;
            }
        }

        return operations+carry;
    }
}