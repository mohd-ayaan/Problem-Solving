class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxheap=new PriorityQueue<>((x,y)->Integer.compare(y[0],x[0]));
        StringBuilder sb=new StringBuilder();

        if(a>0)maxheap.offer(new int[]{a,'a'});
        if(b>0)maxheap.offer(new int[]{b,'b'});
        if(c>0)maxheap.offer(new int[]{c,'c'});

        while(!maxheap.isEmpty()){
            // most frequent
            int[] first=maxheap.poll();
            int freq=first[0];
            char ch=(char)first[1];

            int n=sb.length();
            // check if adding ch1 would create 3 in a row
            if(n>=2 && sb.charAt(n-1)==ch && sb.charAt(n-2)==ch){
                if(maxheap.isEmpty()){break;}

                int[] second=maxheap.poll();
                int freq2=second[0];
                char ch2=(char)second[1];

                sb.append(ch2);
                freq2--;
                if(freq2>0){
                    maxheap.offer(new int[]{freq2,ch2});
                }

                // put first back since we didn't use it this round
                maxheap.offer(first);
            }
            else{
                sb.append(ch);
                freq--;
                
                if(freq>0){
                    maxheap.offer(new int[]{freq,ch});
                }
            }
            
        }
        return sb.toString();
        
    }
}