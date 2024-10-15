import java.util.*;

public class Solution {
    public static int countMaximumOperations(String s, String t) {
        // 建立兩個字母頻率表
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        // 計算 s 的字母頻率
        for (char c : s.toCharArray()) {
            freqS.put(c, freqS.getOrDefault(c, 0) + 1);
        }

        // 計算 t 的字母頻率
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        // 計算可以重組多少次 t
        int maxOperations = Integer.MAX_VALUE;

        for (char c : freqT.keySet()) {
            // 如果 s 中沒有某個 t 中的字符，那就無法重組 t
            if (!freqS.containsKey(c)) {
                return 0;
            }
            // 計算 s 中該字符能提供多少個 t
            maxOperations = Math.min(maxOperations, freqS.get(c) / freqT.get(c));
        }

        return maxOperations;
    }

    public static void main(String[] args) {
        // 測試範例
        String s = "abacbc";
        String t = "bca";
        System.out.println(countMaximumOperations(s, t));  // Output: 2
    }
}
