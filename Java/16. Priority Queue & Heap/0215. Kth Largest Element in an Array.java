// // Using min heap
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

// Using Max Heap
 import java.util.PriorityQueue;

 class Solution {
     public int findKthLargest(int[] nums, int k) {
         // 創建最大堆
             PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

         // 將所有數字加入最大堆
         for (int n : nums) {
             maxHeap.add(n);
         }

         // 移除堆頂元素 k-1 次
         for (int i = 0; i < k - 1; i++) {
             maxHeap.poll();
         }

         // 堆頂元素即為第 k 大的數字
         return maxHeap.peek();
     }
 }


// In Java, a PriorityQueue is implemented using a binary heap, which can either be a min-heap or a max-heap:

// In a min-heap (which is the default in Java), the smallest element always remains at the top of the heap. So when you dequeue or access elements, the smallest element is returned first.
// In a max-heap, the largest element remains at the top and is dequeued first.
// Basic Operations:
// Insert (add() or offer()): Adds an element to the priority queue.
// Remove (poll()): Removes and returns the element with the highest priority (smallest for min-heap, largest for max-heap).
// Peek (peek()): Returns the element with the highest priority without removing it.

// In Java, a PriorityQueue is implemented using a binary heap, which can either be a min-heap or a max-heap:

// In a min-heap (which is the default in Java), the smallest element always remains at the top of the heap. So when you dequeue or access elements, the smallest element is returned first.
// In a max-heap, the largest element remains at the top and is dequeued first.
// Basic Operations:
// Insert (add() or offer()): Adds an element to the priority queue.
// Remove (poll()): Removes and returns the element with the highest priority (smallest for min-heap, largest for max-heap).
// Peek (peek()): Returns the element with the highest priority without removing it.
