import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}

//    backtrack("", 0, 0, 3)
// ├── "(" → backtrack("(", 1, 0, 3)
//         │   ├── "(" → backtrack("((", 2, 0, 3)
//         │   │   ├── "(" → backtrack("(((", 3, 0, 3)
//         │   │   │   ├── ")" → backtrack("((()", 3, 1, 3)
//         │   │   │   │   ├── ")" → backtrack("((())", 3, 2, 3)
//         │   │   │   │   │   ├── ")" → backtrack("((()))", 3, 3, 3) ✅ 加入結果
//         │   │   │   │   │   └── （close == max，無法再加 `)`）
//         │   │   │   ├── （open == max，無法再加 `(`）
//        │   │   ├── ")" → backtrack("(()", 2, 1, 3)
//        │   │   │   ├── "(" → backtrack("(()(", 3, 1, 3)
//        │   │   │   │   ├── ")" → backtrack("(()()", 3, 2, 3)
//        │   │   │   │   │   ├── ")" → backtrack("(()())", 3, 3, 3) ✅ 加入結果
//        │   │   │   ├── ")" → backtrack("(())", 2, 2, 3)
//        │   │   │   │   ├── "(" → backtrack("(())(", 3, 2, 3)
//        │   │   │   │   │   ├── ")" → backtrack("(())()", 3, 3, 3) ✅ 加入結果
//        │   │   └── （close == open，無法再加 `)`）
//        │   ├── ")" → backtrack("()", 1, 1, 3)
//        │   │   ├── "(" → backtrack("()(", 2, 1, 3)
//        │   │   │   ├── "(" → backtrack("()((", 3, 1, 3)
//        │   │   │   │   ├── ")" → backtrack("()(()", 3, 2, 3)
//        │   │   │   │   │   ├── ")" → backtrack("()(())", 3, 3, 3) ✅ 加入結果
//        │   │   │   ├── ")" → backtrack("()()", 2, 2, 3)
//        │   │   │   │   ├── "(" → backtrack("()()(", 3, 2, 3)
//        │   │   │   │   │   ├── ")" → backtrack("()()()", 3, 3, 3) ✅ 加入結果
