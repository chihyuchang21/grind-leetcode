#non-decreasing = sorted --> two-pointers

class Solution(object):
    def sortedSquares(self, nums):
        list = [float('inf')] * len(nums)
        left, right, i = 0, len(nums)-1, len(nums)-1
        while left <= right:
            if nums[left]**2 < nums[right]**2:
                list[i] = nums[right]**2
                right = right - 1 #右指針往左移動
            else: 
                list[i] = nums[left]**2
                left = left + 1 #左指針向右移動
            i = i - 1 #存放結果指針往前平移一位
        return list
