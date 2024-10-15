import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static int findMinPosition(int k, List<Integer> occupiedPositions) {
        // Use a HashSet to store occupied positions for fast lookup
        Set<Integer> occupiedSet = new HashSet<>(occupiedPositions);
        // Count of how many packages have been placed
        int placedCount = 0;
        // Start placing packages from position 1
        int position = 1;

        // Keep searching until we've placed k packages
        while (placedCount < k) {
            // If the current position is not occupied, place a package
            if (!occupiedSet.contains(position)) {
                placedCount++;
            }
            // If k packages have been placed, return the current position
            if (placedCount == k) {
                return position;
            }
            // Move to the next position
            position++;
        }
        return -1; // This should never be reached
    }

    public static void main(String[] args) {
        // Test case
        List<Integer> occupiedPositions = List.of(2, 3, 5);
        int k = 3;
        int result = findMinPosition(k, occupiedPositions);
        System.out.println("The last package was placed at position: " + result);  // Output should be 6
    }
}
