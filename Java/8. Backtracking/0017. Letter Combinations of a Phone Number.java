class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;

        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(0, digits, "", result, digitToChar);
        return result;
    }

    private void backtrack(int i, String digits, String curStr, List<String> result, Map<Character, String> digitToChar) {
        if (curStr.length() == digits.length()) {
            result.add(curStr);
            return;
        }
        for (char c : digitToChar.get(digits.charAt(i)).toCharArray()) {
            backtrack(i + 1, digits, curStr + c, result, digitToChar);
        }
    }
}