// 第一種: 多出的左括號
// 第二種: 沒有多餘，但括號不匹配
// 第三種: 多出的右括號

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}