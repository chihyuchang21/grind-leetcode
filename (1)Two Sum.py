class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        array = {}
        for i,j in enumerate(nums):
            r = target - j
            if r in array: return [array[r],i]
            array[j] = i
