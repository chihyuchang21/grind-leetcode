// Hash Table

class Solution {
    public boolean isAnagram(String s, String t) {
        int [] record = new int[26];

        for (int i = 0, i < s.length(); i++) {
            record[s.charAt(i) - 'a']++; // 不需記住 a 的 ASCII，只要求出相對數值即可
        }

        for (int i = 0, i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {   // 若有數不為 0，說明 s 和 t 一定有誰多字或少字
                return false;
            }
        }
        return true;    // All = 0 -> Valid Anagram!
    }
}