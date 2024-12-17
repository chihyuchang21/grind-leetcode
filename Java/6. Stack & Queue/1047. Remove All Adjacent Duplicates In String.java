// Not familiar to enhanced for loop method, thus change to tranditional for loop
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));
        }

        return result.toString();
    }
}
