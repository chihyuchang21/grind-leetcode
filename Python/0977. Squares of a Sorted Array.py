#non-decreasing = sorted --> two-pointers

#Python2
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

#Python3
class Solution:
    def sortedSqures(self, nums:List[int]) -> List[int]:
        l,r,i = 0, len(nums) - 1, len(nums) - 1
        res = [float('inf')] * len(nums) #不熟

        while l <= r:
            if nums[r]**2 > nums[l]**2:
                res[i] = nums[r]**2
                r -= 1
            else:
                res[i] = nums[l]**2
                l += 1
            i -= 1
        return res

