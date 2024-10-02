public class Solution {
    public String minRemoveToMakeValid(String s) {
        // 存儲需要刪除的括號索引
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // 第一次遍歷來找出不匹配的括號
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // 遇到左括號，記錄其索引
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    // 如果沒有匹配的左括號，記錄這個右括號的索引
                    indexesToRemove.add(i);
                } else {
                    // 有匹配的左括號，將其彈出
                    stack.pop();
                }
            }
        }

        // 將堆疊中剩下的所有不匹配的左括號索引記錄下來
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // 構建結果字串，跳過所有不匹配的括號
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
