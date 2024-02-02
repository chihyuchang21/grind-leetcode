import heapq

class Solution:
    def topKFrequent(self, nums, k):
        # 統計元素出現頻率
        map_ = {}  # nums[i]:對應出現的次數
        for i in range(len(nums)):
            map_[nums[i]] = map_.get(nums[i], 0) + 1

        # 對頻率排序
        # 定義一個小頂堆、大小為k
        pri_que = []

        # 用固定大小為k的小頂堆，掃描所有頻率的數值
        for key, freq in map_.items():
            heapq.heappush(pri_que, (freq, key))
            if len(pri_que) > k:  # 若堆的大小 > k，則隊列彈出、保證堆的大小一直為k
                heapq.heappop(pri_que)

        # 找出前K個高頻元素，因為小頂堆先彈出的是最小的，所以倒序來輸出到數組
        result = [0] * k
        for i in range(k-1, -1, -1):
            result[i] = heapq.heappop(pri_que)[1]
        return result