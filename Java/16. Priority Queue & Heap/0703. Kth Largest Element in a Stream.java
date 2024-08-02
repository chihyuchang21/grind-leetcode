class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int initialK, int[] nums) {
        k = initialK;
        heap = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
