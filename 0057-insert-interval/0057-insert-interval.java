class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> arr=new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1]< newInterval[0]){
            arr.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        int s=newInterval[0],e=newInterval[1];
        while(i<n && intervals[i][0]<=e){
            s=Math.min(intervals[i][0],s);
            e=Math.max(intervals[i][1],e);
            i++;
        }
        arr.add(new int[]{s,e});

        while(i<n){
            arr.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        int[][] res=arr.toArray(new int[arr.size()][]);
        return res;
    }
}