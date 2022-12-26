class KthLargest {
    
    PriorityQueue<Integer> upper = new PriorityQueue<Integer>();
    PriorityQueue<Integer> lower = new PriorityQueue<Integer>();
    int kGlobal = 0;

    public KthLargest(int k, int[] nums) {
        for(int next : nums) {
            upper.add(next);
        }
        
        // leave k largest elements in offer
        kGlobal = k;
        while(upper.size() > k) {
            lower.add(upper.poll());
        }
    }
    
    public int add(int val) {
        if (upper.size() < kGlobal) {
            upper.add(val);
            return upper.peek();
        }
        if (val <= upper.peek()) {
            lower.add(val);
            return upper.peek();
        }
        else {
            lower.add(upper.poll());
            upper.add(val);
            return upper.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */