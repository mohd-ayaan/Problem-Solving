class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> lst=new ArrayList<>();

        int s=intervals[0][0],e=intervals[0][1];

        for(int i=1;i<n;i++){
            //overlap-> find new end time
            if(intervals[i][0]<=e){
                e=Math.max(intervals[i][1],e);
            }
            //gap-> add current merged interval and reset for  new inteval;
            else{
                lst.add(new int[]{s,e});
                s=intervals[i][0];
                e=intervals[i][1];
            }
        }
        lst.add(new int[]{s,e});
        int[][] res=lst.toArray(new int[lst.size()][]);
        return res;

    }
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        meetings=merge(meetings);
        int n=meetings.length;
        int res=0;
        for(int i=0;i<n-1;i++){
            if(meetings[i][1]<meetings[i+1][0]-1){    //atlleat a day is free
                if(meetings[i][1]<days && meetings[i+1][0]<=days){
                    res+=meetings[i+1][0]-meetings[i][1]-1;
                    System.out.println(meetings[i+1][0]-meetings[i][1]-1);
                }
                else{
                    res+=days-meetings[i][1];
                }
            } 

        }
        //if most first day of meeting is not 1
        if(meetings[0][0]>1){res+=meetings[0][0]-1;}
        //if most last day of meeting is not last
        if(meetings[n-1][1]<days){res+=days-meetings[n-1][1];}
        return res;
    }
}