import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // 使用 Set 來存儲所有單詞，方便快速查找
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>(); // 記憶化搜索

        for (String word : words) {
            if (isConcatenated(word, wordSet, memo)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean isConcatenated(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        // 如果已經記憶化，直接返回結果
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        // 遍歷所有可能的分割點
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            // 檢查前綴是否在字典中，並遞歸檢查後綴
            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isConcatenated(suffix, wordSet, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        // 如果無法分解，記錄為 false
        memo.put(word, false);
        return false;
    }
}
