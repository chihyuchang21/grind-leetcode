// Reverse 兩次
// 1. 移除多餘空格: "the sky is blue"
// 2. String反轉: "eulb si yks eht"
// 3. 單字反轉: "blue is sky the"
// https://leetcode.com/problems/reverse-words-in-a-string/solutions/47720/clean-java-two-pointers-solution-no-trim-no-split-no-stringbuilder/

class Solution {
    // main function
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole String
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a , n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < n && a[j] == ' ') j++; // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; //keep non spaces

        }
    }
}