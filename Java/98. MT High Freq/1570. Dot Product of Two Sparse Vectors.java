class SparseVector {

    // Declare map as an instance variable
    Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<>();

        // Putting index & value in the map
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // using "map, not 'vec.map' here"
            int index = entry.getKey();
            int value = entry.getValue();

            // If the other vector also has a non-zero value at the same index
            if (vec.map.containsKey(index)) {
                product += value * vec.map.get(index);  // Multiply and accumulate
            }
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);