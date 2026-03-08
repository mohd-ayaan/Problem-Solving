class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> Odd_max=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> Even_max=new PriorityQueue<>((a,b)->b-a);

        int reminder,n=num;
        int res=0, divisor=1;
        while(n>0){
            reminder=n%10;
            if(reminder%2==0){
                Even_max.offer(reminder);
            }
            else{Odd_max.offer(reminder);}
            if(n>=10){divisor*=10;}
            n/=10;
        }

        n=num;
        while(n>0){
            reminder=n/divisor;
            if(reminder%2==0){
                res=res*10+Even_max.poll();
            }
            else{res=res*10+Odd_max.poll();}
            n=n%divisor;
            divisor/=10;
        }
        if(Even_max.contains(0)){
            for(int ele:Even_max){
                if(ele == 0){res*=10;}
            }
        }
        return res;
    }
}