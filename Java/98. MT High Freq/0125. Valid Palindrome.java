class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // 開始迴圈進行比較
        while (left < right) {
            // 跳過左邊非字母和數字的字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 跳過右邊非字母和數字的字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // 比較字母（忽略大小寫）
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // 一旦發現不相等，返回 false
            }

            left++;
            right--;
        }
        return true; // 完成迴圈則為回文
    }
}
