// you have a sorted array of integers, which may have some duplicate elements, return an array with all the duplicate elements removed. You can also return the number of distinct values in the array along with the array so that it'll be okay to keep some garbage values at the end of the returned array.
// Example:
// input: [1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 7]
// output: [1, 2, 3, 4, 5, 6, 7, 5, 6, 7, 7], 7 ==> 7 distinct values in the array, and the last 4 elements "5, 6, 7, 7" are garbage values.

// edge case: null
// [1,1,1] -> return 1
// HashSet

class Solution {
    public int solution(int[] input) {
        Set<Integer> set = new HashSet<>();

        if (input == null || input.length == 0) {
            return 0;
        }

        for (int element: input) {
            set.add(element);
        }

        int[] result = new int[set.size()];

        set.toArray();
        int index = 0;
        for (int element : set) {
            result[index++] = element;
        }

        return result.length;
    }
}
