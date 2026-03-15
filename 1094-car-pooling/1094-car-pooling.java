class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        //<end time, capacity to restore>
        PriorityQueue<int[]> restore=new PriorityQueue<>((a,b)->a[0]-b[0]);


        for(int i=0;i<n;i++){
            int[] ride=trips[i];
            int num=ride[0];
            int from=ride[1];
            int to=ride[2];

            while(!restore.isEmpty() && restore.peek()[0]<=from){
                capacity+=restore.poll()[1];
            }
            if(capacity>=num){
                capacity-=num;
                restore.offer(new int[]{to,num});
            }
            else{
                return false;
            }
        }
        return true;
    }
}