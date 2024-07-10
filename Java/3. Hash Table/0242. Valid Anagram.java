class Solution {
    public boolean isAnagram(String s, String t) {
        int record[] = new int[26]; // 存放 A~Z 的出現次數

        // 計算 S 字串每個字母出現次數
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        // 計算 T 字串每個字母出現次數
        for (int j = 0; j < t.length(); j++) {
            record[j.charAt(j) - 'a']--;
        }

        // 透過以上+-，若完全相等則 String 會全部 = 0

        for (int count: record) { // not familiar
            if (count != 0) {
            return false;
            }
        }
        return true;
    }
}