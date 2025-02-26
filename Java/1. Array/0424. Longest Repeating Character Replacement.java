// Time Complexity :  O(n)
// Space Complexity : O(1)
class Solution {
    public int characterReplacement(String s, int k) {

        int[] arr = new int[26];
        int largestCount = 0;
        int left = 0
        int maxlen = 0;

        for(int right = 0; right < s.length(); right ++){
            arr[s.charAt(right) - 'A'] += 1;
            largestCount = Math.max(largestCount, arr[s.charAt(right) - 'A']);
            if(right - left + 1 - largestCount > k){
                arr[s.charAt(left) - 'A'] -= 1;
                left ++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}
