class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false; // 除不盡不可能分成等量的組

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        for (int card : hand) {
            if (map.get(card) <= 0) continue;
            for (int i = 1; i < groupSize; i++) {
                int count = map.getOrDefault(card + i, 0);
                if (count > 0) {
                    map.put(card + i, count - 1);
                }
                else
                    return false;
            }
            map.put(card, map.get(card) - 1);
        }

        return true;
    }
}