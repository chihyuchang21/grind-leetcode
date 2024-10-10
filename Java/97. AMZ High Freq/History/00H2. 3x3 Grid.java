// similar to 2268

import java.util.*;

public class KeypadDesign {

    public static int minKeypadClickCount(String text) {
        // Step 1: Count frequency of each letter
        int[] frequency = new int[26];
        for (char c : text.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Step 2: Sort letters by frequency in descending order
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            letters.add((char) (i + 'a'));
        }
        letters.sort((a, b) -> frequency[b - 'a'] - frequency[a - 'a']);

        // Step 3: Assign letters to the keypad (9 buttons, max 3 letters per button)
        Map<Character, Integer> letterToButtonPresses = new HashMap<>();
        int buttonIndex = 0;
        for (int i = 0; i < letters.size(); i++) {
            int pressCount = (i % 3) + 1; // First letter takes 1 press, second takes 2 presses, third takes 3
            letterToButtonPresses.put(letters.get(i), pressCount);
        }

        // Step 4: Calculate total click count for the given text
        int totalClicks = 0;
        for (char c : text.toCharArray()) {
            totalClicks += letterToButtonPresses.get(c);
        }

        return totalClicks;
    }

    public static void main(String[] args) {
        String text = "abacadefghib";
        int result = minKeypadClickCount(text);
        System.out.println("Minimum keypad click count: " + result);
    }
}
