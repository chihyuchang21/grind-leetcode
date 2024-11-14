class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int intervalsRemoved = 0;

        Arrays.sort(intervals,(arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] intervalFirst = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervalFirst[1]) {
                intervalsRemoved++;

                if(intervalFirst[1] > intervals[i][1]) {
                    intervalFirst = intervals[i];
                }
            } else {
                intervalFirst = intervals[i];
            }
        }
        return intervalsRemoved;
    }
}