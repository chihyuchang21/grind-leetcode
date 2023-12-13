#TBC: Dic Method2 & defaultdict
class Solution(object):
    def fourSumCount(self, nums1, nums2, nums3, nums4):
        hashmap = dict()

        for n1 in nums1:
            for n2 in nums2:
                if n1 + n2 in hashmap:
                    hashmap[n1+n2] += 1
                else:
                    hashmap[n1+n2] = 1

        #若-(n1+n2)存在nums3和nums4，存入結果
        count = 0
        for n3 in nums3:
            for n4 in nums4:
                key = -n3 - n4
                if key in hashmap:
                    count += hashmap[key]
        return count