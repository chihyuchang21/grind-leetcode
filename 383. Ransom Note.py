#TBC: Using Dic & count
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        ransom_count = [0] * 26
        magazine_count = [0] * 26

        for c in ransomNote:
            ransom_count[ord(c) - ord('a')] += 1

        for c in magazine:
            magazine_count[ord(c) - ord('a')] += 1

        return all(ransom_count[i] <= magazine_count[i] for i in range(26))