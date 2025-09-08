class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.size() == 0 || num < max.peek()){
            max.add(num);
        }
        else{
            min.add(num);
        }

        if(max.size() >= min.size()+1){
            min.add(max.poll());
        }
        if(min.size() > max.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek()+min.peek())*1.0/2;
        }
        return  max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */