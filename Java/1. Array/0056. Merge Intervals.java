// https://www.youtube.com/watch?v=uiOq8TO5CbE

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        int[] curr = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > curr[1]) {
                res.add(curr);
                curr = intervals[i];
            } else {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }

        res.add(curr);

        return res.toArray(new int[res.size()][2]);
    }
}

// 240916
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> (a[0] - b[0])); // remember!

        int[] curr = intervals[0]; // the element we currently iterate

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > curr[1]) {
                res.add(curr);
                curr = intervals[i];
            } else {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }

        res.add(curr);

        return res.toArray(new int[res.size()][2]);
    }
}