# Matching problem很適合用stack

class Solution:
    def removeDuplicates(self,s):
        res = list()
        for item in s:
            if res and res[-1] == item:
                res.pop()
            else:
                res.append(item)
        return "".join(res) #str拼接