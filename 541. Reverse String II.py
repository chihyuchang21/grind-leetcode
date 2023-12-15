class Solution(object):
    def reverseStr(self, s, k):
        """
        1. 使用range(start, end, step)確定要exchange的position
        2. 避免一些邊界的處理 --> s = 'abc' 使用 s[0:999] = 'abc'替換
        3. 用切片整體替換，不要一個個替換
        """
        def reverse_substring(text):
            left, right = 0, len(text) - 1
            while left < right:
                text[left], text[right] = text[right], text[left]
                left += 1
                right -= 1
            return text

        res = list(s)

        #從0開始，每隔2*k個字符取一個子串
        for cur in range(0, len(s), 2*k):
            res[cur: cur + k] = reverse_substring(res[cur: cur + k])

        return ''.join(res)