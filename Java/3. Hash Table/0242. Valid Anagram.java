class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqArray = new int [26];

        for (int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i) - 'a'] += 1;
        }

        for (int j = 0; j < t.length(); j++) {
            freqArray[t.charAt(j) - 'a'] -= 1;
        }

        for (int element: freqArray) {
            if (element != 0) {
                return false;
            } 
        }
        return true;
    }
}

// [1,2,3, .....]
// [0,0,0, .....]

// TC: O(M + N)
// SC: O(1)
// freqArray uses fixed size int[26] → O(1)