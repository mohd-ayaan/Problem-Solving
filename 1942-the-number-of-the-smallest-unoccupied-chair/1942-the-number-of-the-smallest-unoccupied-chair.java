class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int arrivalOfTarget=times[targetFriend][0];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        //<endingtime,chairNumber>
        PriorityQueue<int[]> occupied=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> free=new PriorityQueue<>();
        int nextFreeChair=0;
        


        //till target arrival is not reached(we have distinct sorted arrival time)
        for(int[] friend: times){
            int arrive=friend[0];
            int leave=friend[1];

            //remove timeout friends and update minfreechair 
            while(!occupied.isEmpty() && occupied.peek()[0]<=arrive){
                free.offer(occupied.poll()[1]);
            }

            int freeChair;
            if(!free.isEmpty()){freeChair=free.poll();}
            else{freeChair=nextFreeChair++;}
            occupied.offer(new int[]{leave,freeChair});

            if(arrivalOfTarget==arrive){
                return freeChair;
            }
        }
        return -1;
    }
}