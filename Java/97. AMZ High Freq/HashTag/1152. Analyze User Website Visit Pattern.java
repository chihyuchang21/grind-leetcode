import java.util.*;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Step 1: 將數據結合並排序
        int n = username.length;
        List<String[]> data = new ArrayList<>(); // 使用 List<String[]> 儲存訪問記錄
        for (int i = 0; i < n; i++) {
            data.add(new String[]{username[i], String.valueOf(timestamp[i]), website[i]});
        }
        // 按時間戳排序
        data.sort((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

        // Step 2: 按用戶分組訪問記錄
        Map<String, List<String>> userVisits = new HashMap<>();
        for (String[] record : data) {
            userVisits.putIfAbsent(record[0], new ArrayList<>());
            userVisits.get(record[0]).add(record[2]); // record[2] 是網站
        }

        // Step 3: 統計所有用戶的三元組模式
        Map<String, Integer> patternCount = new HashMap<>();
        for (String user : userVisits.keySet()) {
            List<String> websites = userVisits.get(user);
            Set<String> seenPatterns = new HashSet<>(); // 去重
            int m = websites.size();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    for (int k = j + 1; k < m; k++) {
                        String pattern = websites.get(i) + "," + websites.get(j) + "," + websites.get(k);
                        if (!seenPatterns.contains(pattern)) {
                            seenPatterns.add(pattern);
                            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        // Step 4: 找出頻率最高且字典序最小的三元組
        String mostFrequentPattern = "";
        int maxCount = 0;
        for (String pattern : patternCount.keySet()) {
            int count = patternCount.get(pattern);
            if (count > maxCount || (count == maxCount && pattern.compareTo(mostFrequentPattern) < 0)) {
                mostFrequentPattern = pattern;
                maxCount = count;
            }
        }

        // 將結果轉為列表格式
        return Arrays.asList(mostFrequentPattern.split(","));
    }
}
