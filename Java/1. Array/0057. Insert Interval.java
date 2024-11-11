class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                res.add(interval);
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            // 當前區間在 newInterval 左側，無需合併
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            }
            // 當前區間在 newInterval 右側，無需合併，直接加入 newInterval
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = interval;  // 將 newInterval 更新為當前區間，繼續遍歷
            }
            // 有重疊情況，合併區間
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        // 如果 newInterval 還沒插入，加入最後
        res.add(newInterval);

        // 將結果轉換為二維陣列並返回
        return res.toArray(new int[res.size()][]);
    }
}


/**
 * 240809
 *
 * # Understand
 * 1. Are the intervals in the input array guaranteed to be sorted in ascending order?
 * 2. Can the input array of intervals contain overlapping intervals before inserting the new interval?
 * 3. What should be the behavior if the new interval is exactly the same as one of the existing intervals?
 *
 *
 * # Match
 * 1. Brute Force Array)
 *      TC: O(N)
 *      SC: O(N)
 * 2. Two Pts
 *      TC: O(N)
 *      SC: O(N) (use additional space to store the result list)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * 1. interval[1] < newInterval[0] -> The condition checks if the current interval is completely before the newInterval
 *    Ex1. Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 *    If 3 < 2 ?
 * 2. res.toArray(new int[res.size()][])
 * 3. exchange
 *
 */