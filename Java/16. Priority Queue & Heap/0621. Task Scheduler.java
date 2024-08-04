class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(counts.values());

        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();  // pairs of [cnt, idleTime]
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            if (!queue.isEmpty() && time >= queue.peek()[1]) {
                maxHeap.offer(queue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    queue.offer(new int[]{cnt, time + n + 1});
                }
            }
            time++;
        }
        return time;
    }
}
