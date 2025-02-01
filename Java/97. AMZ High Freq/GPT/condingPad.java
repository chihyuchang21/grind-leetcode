//        2 -> "abc"
//        3 -> "def"
//        4 -> "ghi"
//        5 -> "jkl"
//        6 -> "mno"
//        7 -> "pqrs"
//        8 -> "tuv"
//        9 -> "wxyz"

// Test Cases:


// Brute Force: 2 for loop
class Solution {
    public int[] sumTarget(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null; // not possible;
    }
}

class Solution {
    public int[] sumTarget(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // K, V = deduction, freq // edit -> K: nums[i] ; V: index
        for (int i = 0; i < nums.length; i++) {
            int deduction = target - nums[i];
            if (map.containsKey(deduction)) {
                return new int[]{i, map.get(deduction)};
            }
        map.put(nums[i], i);
        }
    }
}


// Test Cases:
// Positive: [1,2,3,4,5] t: 2 -> 2
// Negative: [1,2,3,4,5] t: 6 ->  -1
// Edge: [] t:5 -> -1

// Des Order: [5,4,3,2,1]

// I guess I will use Binary Search, should I start?
class Solution {
    public int binarySearch(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;

       // loop
       while (left <= right) {
           int mid = left + (right - left) / 2;
           // if statement
           if (nums[mid] > target) {
              right = mid + 1;
           } else if ( nums[mid] < target ) {
               left = mid - 1;
           } else {
               return mid;
           }
       }

       return - 1;
    }
}