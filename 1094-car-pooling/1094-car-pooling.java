class Solution {
    //O(n*n)
    // public boolean carPooling(int[][] trips, int capacity) {
    //     int n=trips.length;
    //     //<end time, capacity to restore>
    //     Arrays.sort(trips,(a,b)->a[1]-b[1]);
    //     PriorityQueue<int[]> restore=new PriorityQueue<>((a,b)->a[0]-b[0]);

    //     for(int i=0;i<n;i++){
    //         int[] ride=trips[i];
    //         int num=ride[0];
    //         int from=ride[1];
    //         int to=ride[2];

    //         while(!restore.isEmpty() && restore.peek()[0]<=from){
    //             capacity+=restore.poll()[1];
    //         }
    //         if(capacity>=num){
    //             capacity-=num;
    //             restore.offer(new int[]{to,num});
    //         }
    //         else{
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] t : trips)
            max = Math.max(max, t[2]);

        int[] diff = new int[max + 1];
        for (int[] t : trips) {
            diff[t[1]] += t[0]; // pickup
            diff[t[2]] -= t[0]; // dropoff
        }

        int curr = 0;
        for (int i = 0; i <= max; i++) {
            curr += diff[i];
            if (curr > capacity)
                return false;
        }
        return true;
    }
}