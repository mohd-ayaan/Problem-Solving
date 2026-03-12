class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        // Min-heap based on capital required
        PriorityQueue<int[]> mincapital=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        // Max-heap based on profit
        PriorityQueue<Integer> maxprofit=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int i=0;i<n;i++){
            mincapital.offer(new int[]{capital[i],i});
        }
        while(k-->0){
            // Move all projects that can be afforded into maxProfit
            while(!mincapital.isEmpty() && w>=mincapital.peek()[0]){ 
                maxprofit.offer(profits[mincapital.poll()[1]]);
            }

            // If no project can be chosen, break
            if(maxprofit.isEmpty()){break;}

            // Choose the most profitable project
            w+=maxprofit.poll();

        }
        return w;
    }
}