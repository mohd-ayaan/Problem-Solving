class MedianFinder {
    PriorityQueue<Integer> left; //max priority
    PriorityQueue<Integer> right; //min priority
    List<Integer> temp;
    public MedianFinder() {
        left=new PriorityQueue<>((a,b)->b-a);
        right=new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if(right.size()>left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){return (left.peek()+right.peek())/2.0;}
        else{return (double)left.peek();}
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */