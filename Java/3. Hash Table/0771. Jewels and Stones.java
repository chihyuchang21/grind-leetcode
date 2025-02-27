class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        for (int j = 0; j < stones.length(); j++) {
            if (set.contains(stones.charAt(j))) {
                count += 1;
            }
        }
        return count;
    }
}