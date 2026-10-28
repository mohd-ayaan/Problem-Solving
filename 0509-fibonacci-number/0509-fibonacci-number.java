class Solution {
    public int fib(int n) {
        if(n<2)return n;
        int past2=0, past1=1, current;
        for(int i=2;i<=n;i++){
            current=past1+past2;
            past2=past1;
            past1=current;
        }

        return past1;
    }
}