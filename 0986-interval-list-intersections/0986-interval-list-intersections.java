class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n1=firstList.length;
        int n2=secondList.length;
        List<int[]> lst=new ArrayList<>();
        int s,e;
        int i=0,j=0;  //Pointer for lists

        while(i<n1 && j<n2){
            //overlap
            if(firstList[i][1]>=secondList[j][0] && firstList[i][0]<=secondList[j][1]){
                s=Math.max(firstList[i][0],secondList[j][0]);
                e=Math.min(firstList[i][1],secondList[j][1]);

                lst.add(new int[]{s,e});
            }
            if(firstList[i][1]<secondList[j][1]){i++;}
            else{j++;}
        }

        return lst.toArray(new int[lst.size()][]);
    
    }
}