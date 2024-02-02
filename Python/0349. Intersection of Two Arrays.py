#Method1: Using SET
class Solution(object):
    def intersection(self, nums1, nums2):
        return list(set(nums1) & set(nums2))

#TBC: Using Array * Dictionary