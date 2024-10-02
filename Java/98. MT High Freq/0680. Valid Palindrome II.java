class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // 使用雙指針從兩端向中間移動
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 如果左右不相同，檢查刪除一個字符後是否為回文
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    // 檢查子串是否為回文
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
