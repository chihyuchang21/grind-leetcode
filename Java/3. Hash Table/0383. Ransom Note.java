public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 建立一個 HashMap 來記錄雜誌中每個字母的次數
        HashMap<Character, Integer> charCount = new HashMap<>();

        // 計算雜誌中每個字母的出現次數
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 檢查勒索信中的每個字母是否存在於雜誌中，且次數足夠
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                // 如果字母不存在或次數不足，返回 false
                return false;
            }
            // 使用一次該字母後，減少字母的次數
            charCount.put(c, charCount.get(c) - 1);
        }

        // 所有字母都符合條件，返回 true
        return true;
    }
}
