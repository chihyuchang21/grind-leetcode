class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int maxSoFar = 0;  // Initialize the maximum height seen so far (starting from the right)

        // Traverse from right to left
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxSoFar) {
                result.add(i);  // Add the building's index if it has an ocean view
                maxSoFar = heights[i];  // Update the max height seen so far
            }
        }

        // Since we added the results in reverse order, we need to reverse them back
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(result.size() - 1 - i);
        }

        return output;
    }
}
