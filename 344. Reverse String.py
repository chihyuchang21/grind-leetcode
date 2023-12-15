#不要直接用reverse

class Solution(object):
    def reverseString(self, s):
        left, right = 0, len(s) - 1

        #用while比for complexity低

        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1