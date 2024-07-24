class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, preMap, visiting)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs, HashMap<Integer, List<Integer>> preMap, Set<Integer> visiting) {
        if (visiting.contains(crs)) {
            return false;
        }

        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visiting.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre, preMap, visiting)) {
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}