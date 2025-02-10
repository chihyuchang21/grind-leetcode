class Solution {
    public String clearDigits(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 如果遇到數字，就移除 stack 頂部的字母
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // 如果是字母，則加入 stack
                stack.push(c);
            }
        }

        // 把 stack 內的字母重組回字串
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}
