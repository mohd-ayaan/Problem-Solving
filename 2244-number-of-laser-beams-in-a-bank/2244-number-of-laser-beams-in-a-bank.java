class Solution {
    public int numberOfBeams(String[] bank) {
        int m=bank.length;
        int res=0, lastbeamcnt=0;
        for(int i=0;i<m;i++){
            int cntbeam=0;
            for(Character tile:bank[i].toCharArray()){
                if(tile=='1'){cntbeam+=1;}
            }
            res+=lastbeamcnt*cntbeam;
            if(cntbeam!=0){lastbeamcnt=cntbeam;}
            
        }
        return res;
        
    }
}