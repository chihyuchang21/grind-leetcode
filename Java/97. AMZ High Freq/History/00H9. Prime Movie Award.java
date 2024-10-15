import java.util.Arrays;

public class MovieGroups {
    public static void main(String[] args) {
        // List of movie awards
        int[] awards = {1, 5, 4, 6, 8, 9, 2};
        int k = 3;  // Maximum allowed difference between awards in a group

        // Step 1: Sort the awards array
        Arrays.sort(awards);

        // Initialize the minimum number of groups
        int count = 1;
        // The first movie's award count is the minimum for the current group
        int min = awards[0];

        // Step 2: Iterate through the sorted awards array
        for (int i = 1; i < awards.length; i++) {
            // Check if the current movie's award count exceeds the allowable difference
            if (Math.abs(awards[i] - min) > k) {
                // Start a new group since the difference exceeds k
                count++;
                // Set the new minimum award count for the new group
                min = awards[i];
            }
        }

        // Output the minimum number of groups
        System.out.println("The minimum number of groups is: " + count);
    }
}

