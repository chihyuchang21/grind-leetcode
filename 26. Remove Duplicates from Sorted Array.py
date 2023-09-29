class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        z=0
        if  nums ==[] :
            return 0
        if len(nums)==1:
            return 1
        for i in range(0,len(nums)):
            if nums[z]!=nums[i]:
                z+=1
                nums[z]=nums[i]
        return z+1
