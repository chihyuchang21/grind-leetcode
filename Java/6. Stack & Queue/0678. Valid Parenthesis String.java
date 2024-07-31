class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>(); // 用來存放 '(' 的索引
        Stack<Integer> starStack = new Stack<>(); // 用來存放 '*' 的索引

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                // 遇到 ')'
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        // 檢查剩餘的 '(' 和 '*' 是否可以匹配
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }
}
