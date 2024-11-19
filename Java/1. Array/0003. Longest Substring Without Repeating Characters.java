// // Brute Force: HashSet + Without Sliding Window
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;

//         for (int i = 0; i < n; i++) {
//             HashSet<Character> set = new HashSet<>();

//             for (int j = i; j < n; j++) { // Should start from "i"!
//                 if (set.contains(s.charAt(j))) {
//                     break;
//                 }
//                 // If char is not in the set, add it to the set!
//                 set.add(s.charAt(j));

//                 // Update maxLength
//                 // j - i + 1: The length of the current valid substring
//                 maxLength = Math.max(maxLength, j - i + 1);
//             }
//         }
//         return maxLength;

//     }
// }


// O(N) Solution: HashSet + Sliding Window
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 使用 HashSet 來記錄當前窗口內的字符
        HashSet<Character> charSet = new HashSet<>();
        int maxLength = 0; // 記錄最大子字串長度
        int left = 0; // 左指針，初始為 0

        // 右指針遍歷整個字串
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 如果當前字符已經存在於窗口內，則移動左指針，直到移除重複的字符
            while (charSet.contains(c)) {
                left++; // 移動左指針
            }

            // 將當前字符加入到 Set 中
            charSet.add(c);

            // 更新最大子字串的長度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // 返回最長的子字串長度
    }
}



