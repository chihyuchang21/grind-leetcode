class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        for(int i = 0; i < ch.length - 1; i += 2 * k) {
            int start = i;
            // 判斷尾數夠不夠 k 個來取決 end 指針的位置 (need to review)
            int end = Math.min(ch.length - 1, start + k - 1);

            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }
}