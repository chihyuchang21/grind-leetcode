#Two pts

class Solution(object):
    def reverseWords(self,s):
        words = s.split()

        left, right = 0, len(words) - 1
        while left < right:
            words[left], words[right] = words[right], words[left]
            left += 1
            right -= 1
        return " ".join(words)

'''
先刪空白再組裝

class Solution(object):
    def reverseWords(self, s):
        s = s.strip() #delete space first
        s = [::-1] #reverse whole Str
        s = ''.join(word[::-1] for word in s.split())
        return s
        
'''
