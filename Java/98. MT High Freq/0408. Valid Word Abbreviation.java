class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // word 的指標
        int j = 0; // abbr 的指標

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                // 檢查數字不能以 '0' 開頭
                if (abbr.charAt(j) == '0') {
                    return false;
                }

                // 計算數字大小，然後跳過對應數量的字母
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // 在 word 中跳過 num 個字母
            } else {
                // 檢查字母是否匹配
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }

        // 檢查是否已經完全遍歷 word 和 abbr
        return i == word.length() && j == abbr.length();
    }
}
