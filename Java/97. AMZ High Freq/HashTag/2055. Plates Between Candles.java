// To check if left & right are tables, if yes -> candle numberes: right - left - 1
// String s -> .charAt

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];

        // 遍歷每個查詢
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // 找到範圍內的第一個蠟燭
            int leftCandle = -1;
            for (int j = left; j <= right; j++) {
                if (s.charAt(j) == '|') {
                    leftCandle = j;
                    break;
                }
            }

            // 找到範圍內的最後一個蠟燭
            int rightCandle = -1;
            for (int j = right; j >= left; j--) {
                if (s.charAt(j) == '|') {
                    rightCandle = j;
                    break;
                }
            }

            // 如果找到有效的左蠟燭和右蠟燭，計算盤子數量
            if (leftCandle != -1 && rightCandle != -1 && leftCandle < rightCandle) {
                int plates = 0;
                for (int j = leftCandle + 1; j < rightCandle; j++) {
                    if (s.charAt(j) == '.') {
                        plates++;
                    }
                }
                result[i] = plates;
            } else {
                result[i] = 0; // 沒有有效範圍，盤子數量為 0
            }
        }

        return result;
    }
}


// 時間複雜度是 O(q * n)，而不是 O(n²)，因為內層迴圈執行次數僅與查詢範圍相關，而不是總字符串長度的平方
// O(Q * N) -> O(N)
// 在大多數問題中，Q 是隨著輸入規模變化的，並不是固定的常數。

// TLE
// PrefixSum
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n];      // 前綴和：記錄每個位置之前的盤子數量
        int[] leftCandle = new int[n];    // 左邊最近的蠟燭索引
        int[] rightCandle = new int[n];   // 右邊最近的蠟燭索引
        int[] result = new int[queries.length];

        // Step 1: 構建前綴和
        int plates = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                plates++; // 遇到盤子，累加
            }
            prefixSum[i] = plates;
        }

        // Step 2: 構建左邊最近的蠟燭索引
        int candle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candle = i; // 更新最近的蠟燭索引
            }
            leftCandle[i] = candle;
        }

        // Step 3: 構建右邊最近的蠟燭索引
        candle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candle = i; // 更新最近的蠟燭索引
            }
            rightCandle[i] = candle;
        }

        // Step 4: 處理每個查詢
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // 找到範圍內有效的蠟燭位置
            int l = rightCandle[left];    // 查詢範圍內左側的第一個蠟燭
            int r = leftCandle[right];   // 查詢範圍內右側的最後一個蠟燭

            // 如果有效蠟燭範圍存在，計算盤子數量
            if (l != -1 && r != -1 && l < r) {
                result[i] = prefixSum[r] - prefixSum[l];
            } else {
                result[i] = 0; // 沒有有效範圍，結果為 0
            }
        }

        return result;
    }
}

