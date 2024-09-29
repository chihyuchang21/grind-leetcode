class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        // 記錄每個字母出現的次數
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // 將當前字母加入統計
            count[s.charAt(right) - 'A']++;
            // 更新當前窗口內出現最多的字母次數
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // 如果窗口內需要替換的字母數量大於 k，縮小窗口
            if (right - left + 1 - maxCount > k) {
                // 縮小左邊界，減少對應字母的計數
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // 更新最大子字串長度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
