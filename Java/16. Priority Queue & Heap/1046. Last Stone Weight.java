class Solution {
// 用 MaxHeap 的技巧 -> 若不用 Comparator，用負數
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue();
        for (int stone : stones) maxHeap.add(-stone);
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();
            if (stone1 != stone2) maxHeap.add(stone1 - stone2);
        }

        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.remove();
        }
}

// 用 Comparator 實現
class Solution {
    public int lastStoneWeight(int[] stones) {
        // 使用 PriorityQueue 實現最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 將所有石頭加入堆
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // 模擬石頭碰撞的過程
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove(); // 取出最大石頭
            int stone2 = maxHeap.remove(); // 取出第二大石頭

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // 差值放回堆中
            }
        }

        // 返回結果
        if (maxHeap.isEmpty()) {
            return 0; // 堆空，返回 0
        } else {
            return maxHeap.remove(); // 堆中剩下最後一塊石頭
        }
    }
}



