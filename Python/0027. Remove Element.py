#Python2
class Solution(object):
    def removeElement(self, nums, val):
        k = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
        return k
#ref: https://www.youtube.com/watch?v=AwypqqTJd8Q

#Python3
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        fast = 0
        slow = 0
        size = len(nums)

        while fast < size: #=不算因為nums[size]越界
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow