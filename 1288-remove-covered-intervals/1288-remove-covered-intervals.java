class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int res=0;
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        for(int i=n-1;i>0;i--){
            boolean include=true;
            for(int j=i-1;j>=0;j--){
                if(intervals[i][1]<=intervals[j][1]){
                    include=false;
                    break;
                }
            }
            if(include==true){res++;}
        }
        return res+1;

    }
}