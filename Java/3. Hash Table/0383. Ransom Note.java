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

// 241211: Figure out by myself but it's better to use only one HashMap and deduct them
// (And a little not familiar to Map.Entry method)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // if ransomNote can be constructed by using magazine -> true
        // create 2 HashTable record the appearing freq and check if the elements in rN is are concluded in mgz
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            map1.put(ransomNote.charAt(i), map1.getOrDefault(ransomNote.charAt(i),0) + 1);
        }

        for (int j = 0; j < magazine.length(); j++) {
            map2.put(magazine.charAt(j), map2.getOrDefault(magazine.charAt(j),0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char c = entry.getKey();
            int needed = entry.getValue();
            if (needed > map2.getOrDefault(c, 0)) {
                return false;
            }
        }

        return true;
    }
}

// reference for the next time (using only one map):
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];  // 假設只有小寫字母

        // 計數 magazine 中每個字符的出現次數
        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']++;
        }

        // 檢查 ransomNote 中的每個字符是否能被 magazine 覆蓋
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (charCount[index]-- <= 0) {
                return false;  // 如果某個字符計數為零或低於零，表示 magazine 中的字符不足以構建 ransomNote
            }
        }

        return true;
    }
}
