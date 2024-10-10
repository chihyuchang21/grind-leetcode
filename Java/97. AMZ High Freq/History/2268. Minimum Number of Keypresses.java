public class Solution {
    public int minimumKeypresses(String s) {
        // Step 1: Count the frequency of each letter in the input string
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Sort the letter frequencies in descending order
        Arrays.sort(freq);

        // Step 3: Assign the most frequent letters to the first, second, and third positions
        int presses = 0;
        int position = 1;  // Starting from 1 press for the first 9 letters
        for (int i = 25; i >= 0; i--) {  // Reverse loop since the array is sorted in ascending order
            if (freq[i] == 0) break;  // No more letters to assign
            presses += freq[i] * position;
            if ((26 - i) % 9 == 0) {
                position++;  // Move to the next group of buttons (2nd, 3rd positions)
            }
        }

        return presses;
    }
