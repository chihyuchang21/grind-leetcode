class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildStack(s).equals(buildStack(t));
    }

    private Stack<Character> buildStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack;
    }
}