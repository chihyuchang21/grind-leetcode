// similar - 206: reverse linked list, 2 pts, easy

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }

    // 2nd 240627
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left]; // use char!
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}