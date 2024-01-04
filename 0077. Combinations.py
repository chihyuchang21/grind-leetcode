class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = [] #存放結果集
        self.backtracking(n, k, 1, [], result)
        return result

    def backtracking(self, n, k, startIndex, path, result):
        if len(path) == k:
            result.append(path[:])
            return

        for i in range(startIndex, n - (k - len(path)) + 2):
            path.append(i) #處理節點
            self.backtracking(n, k, i + 1, path, result)
            path.pop() #backtracking，撤銷處理的節點
