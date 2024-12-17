// maxHeap -> can't memorize
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 使用 HashMap 統計頻率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. 建立最小堆，按照頻率排序 (比較器: 頻率升序)
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue() // 比較頻率大小
        );

        // 3. 遍歷 map，將元素放入最小堆
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) { // 當堆的大小超過 k，移除堆頂（頻率最低的）
                minHeap.poll();
            }
        }

        // 4. 將堆中的元素取出，放入結果陣列
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().getKey();
        }
        return ans;
    }
}
