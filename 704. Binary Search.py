#sorted, unique, O(log n) --> binary search
class Solution(object):
    def search(self, nums, target):
        left, right = 0, len(nums)-1

        while left <= right:
            middle = left + (right-left) // 2

            if nums[middle] > target:
                right = middle - 1 #target在左區間
            elif nums[middle] < target:
                left = middle + 1 #target在右區間
            else:
                return middle
        return -1 #未找到目標值
