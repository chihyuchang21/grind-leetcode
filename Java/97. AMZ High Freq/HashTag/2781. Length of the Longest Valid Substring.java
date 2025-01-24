class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>();
        for (String f : forbidden) {
            set.add(f);
        }

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < word.length(); right++) {
            // 1 <= forbidden[i].length <= 10
            for (int len = 1; len <= 10 && right - len + 1 >= left; len++) {
                String sub = word.substring(right - len + 1, right + 1);
                if (set.contains(sub)) {
                    left = right - len + 2;
                    break;
                }
            }
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}