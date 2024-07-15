// 消除在 stack 中已出現過的 element，return 所有在 stack 中的東西
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            // 若 stack 不為空、且最上面的元素為現在遍歷到的元素，則彈出
            if (!st.isEmpty() && st.peek() == c) {
                st.pop(); // remove
            } else {
                st.push(c); // 把 c push 入 stack
            }
        }

        String result = ""; // 初始化 String

        while (!st.isEmpty()) {
            result = st.pop() + result; // think!
        }

        return result;
    }
}