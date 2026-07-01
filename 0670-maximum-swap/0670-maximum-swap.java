class Solution {
    //greedy TC: O(digits)
    public int maximumSwap(int num) {
        char[] digits=String.valueOf(num).toCharArray();
        int[] last=new int[10];

        // record last occurrence of each digit
        for(int i=0;i<digits.length;i++){
            last[digits[i]-'0']=i;
        }

        for(int i=0;i<digits.length;i++){
            int current=digits[i]-'0';
            // check if a larger digit exists later
            for(int d=9;d>current;d--){
                if(last[d]>i) //bigger digit index must come after current changing index.
                {
                    //swap
                    char t=digits[i];
                    digits[i]=digits[last[d]];
                    digits[last[d]]=t;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}