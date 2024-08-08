class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> subString = new ArrayList<>();
        int largestLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (subString.contains(currentChar)) {
                int index = subString.indexOf(currentChar);
                subString = subString.subList(index + 1, subString.size());
            }

            subString.add(currentChar);
            largestLength = Math.max(largestLength, subString.size());
        }

        return largestLength;
    }
}
