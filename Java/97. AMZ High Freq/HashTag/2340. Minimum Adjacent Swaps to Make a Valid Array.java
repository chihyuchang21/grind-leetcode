class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;

        // Handle the edge case where the array has only one element
        if (n == 1) {
            return 0; // No swaps needed for a single element
        }

        int minIndex = 0;
        int maxIndex = 0;

        // Step 1: Find the leftmost smallest and rightmost largest elements
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) { // Update minIndex if a smaller value is found
                minIndex = i;
            }
            if (nums[i] >= nums[maxIndex]) { // Update maxIndex for the rightmost largest value
                maxIndex = i;
            }
        }

        // Step 2: Calculate the number of swaps
        if (minIndex < maxIndex) {
            // No overlap between the movements
            return minIndex + (n - 1 - maxIndex);
        } else {
            // Overlap between the movements, subtract 1
            return minIndex + (n - 1 - maxIndex) - 1;
        }
    }
}
