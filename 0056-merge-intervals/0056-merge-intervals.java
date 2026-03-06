class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> lst=new ArrayList<>();

        //sort based on start time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
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
}