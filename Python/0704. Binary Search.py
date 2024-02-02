#sorted, unique, O(log n) --> binary search

#Python2
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

#Python3 1/3/24
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1  #定義區間為左閉右閉

        while left <= right:
            middle = (left + right) // 2
            if target < nums[middle]:
                right = middle - 1      #因為有算middle本身
            elif target > nums[middle]:
                left = middle + 1
            else:
                return middle
        return - 1