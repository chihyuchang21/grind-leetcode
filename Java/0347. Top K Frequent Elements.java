// maxHeap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // key -> element ; value -> frequency

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // 這個記 freq 的方法第二次出現了
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair[1]); // 表示用數組中第二個元素（索引為 1 的元素）來比較：
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int [] ans = new int[k];
        for (int i = 0; i < k; i++) {   // 依次彈出 k 個
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}