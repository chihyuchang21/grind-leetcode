import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        // Step 1: 統計字符頻率
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: 構建最大堆 (PriorityQueue)
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freq[b - 'a'] - freq[a - 'a'] // 按照頻率降序排列
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // 如果某個字符的頻率大於 (n + 1) / 2，則無解
                if (freq[i] > (s.length() + 1) / 2) {
                    return ""; // 無法重新排列
                }
                maxHeap.add((char) (i + 'a'));
            }
        }

        // Step 3: 組裝結果字符串
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            // 每次從堆中取出頻率最高的兩個字符
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            // 將它們依次加入結果
            result.append(first);
            result.append(second);

            // 更新頻率並將剩餘的字符重新放回堆中
            freq[first - 'a']--;
            freq[second - 'a']--;
            if (freq[first - 'a'] > 0) {
                maxHeap.add(first);
            }
            if (freq[second - 'a'] > 0) {
                maxHeap.add(second);
            }
        }

        // 處理剩餘的字符
        if (!maxHeap.isEmpty()) {
            result.append(maxHeap.poll());
        }

        return result.toString();
    }
}
