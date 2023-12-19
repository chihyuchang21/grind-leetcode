#brute force: using 2 for loop

class Solution(object):
    def isAnagram(self, s, t):
        record = [0] * 26

        for i in s:
            record[ord(i) - ord("a")] += 1

        for i in t:
            record[ord(i) - ord("a")] -= 1

        for i in range(26):
            if record[i] != 0: #代表s,t一定有多或有少
                return False
        return True