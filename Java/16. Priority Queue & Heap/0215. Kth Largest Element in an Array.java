class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // create a min heap

        for (int n : nums) {
            heap.add(n); // add integer to heap

            if(heap.size() > k) {
                heap.poll(); // remove root element
            }
        }
        return heap.peek();
    }
}

// In Java, a PriorityQueue is implemented using a binary heap, which can either be a min-heap or a max-heap:

// In a min-heap (which is the default in Java), the smallest element always remains at the top of the heap. So when you dequeue or access elements, the smallest element is returned first.
// In a max-heap, the largest element remains at the top and is dequeued first.
// Basic Operations:
// Insert (add() or offer()): Adds an element to the priority queue.
// Remove (poll()): Removes and returns the element with the highest priority (smallest for min-heap, largest for max-heap).
// Peek (peek()): Returns the element with the highest priority without removing it.
