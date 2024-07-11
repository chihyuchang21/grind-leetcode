// can't figure out by myself
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }

        // easy to understand
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}

// 240711: 2nd
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int getNextNumber(n) {
        res = 0; // 用來存放計算結果
        while (n > 0) { // 若 n = 0 則表示所有位數遍歷完畢
            int temp = n % 10; // 個位數
            res += temp * temp;
            n = n / 10; // 往上一位
        }
    }
}