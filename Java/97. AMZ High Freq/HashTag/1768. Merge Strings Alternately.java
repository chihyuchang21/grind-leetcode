class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int w1Length = word1.length();
        int w2Length = word2.length();
        int totalLength = w1Length + w2Length;

        int i = 0;

        while (i < w1Length && i < w2Length) {
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
            i++;
        }

        if (i < w1Length) {
            str.append(word1.substring(i));
        }

        if (i < w2Length) {
            str.append(word2.substring(i));
        }

        return str.toString();
    }
}
