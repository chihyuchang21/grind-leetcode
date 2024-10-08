public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // 保存當前的結果和運算符
                stack.push(result);
                stack.push(sign);
                // 重置結果和運算符
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                // 彈出運算符和結果並更新當前結果
                result = stack.pop() * result + stack.pop();
            }
        }

        // 如果還有剩餘的數字，進行最終的加法
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
