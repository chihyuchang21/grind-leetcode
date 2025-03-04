/* ==========================================================
 *                   !Let's do Grid 75 Again!
 * ========================================================== */
/* ==========================================================
 *                      01: Two Sum (Array)
 * ========================================================== */
// Brute Force:
 class Solution {
     public int[] twoSum(int[] nums, int target) {
         int[] result = new int[2];
         for (int i = 0; i < nums.length; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[i] + nums[j] == target) {
                     result[0] = i;
                     result[1] = j;
                 }
             }
         }
         return result;
     }
 }

// TC: O(N^2) ; SC: O(N) -> wrong, it's O(1)
// 在時間與空間複雜度的分析中，N 通常代表 輸入資料的大小
// 空間複雜度 O(1) → 代表你的程式碼只使用固定大小的額外變數（與 N 無關）

// Optimization:
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // (K,V) = (Value, Index)
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // K:  0  1  2  3
        // V: (2, 7, 11,15)

        for (int i = 0; i < nums.length; i++) {
            int deduction = target - nums[i];
            if (map.containsKey(deduction) && map.get(deduction) != i) {
                result[0] = map.get(deduction);
                result[1] = i;
            }
        }

        return result;
    }
}

// TC: O(N) ; SC: O(N)
// HashMap 最多存儲 N 個 Key-Value 對，因此最壞情況需要 O(N) 空間。

/* ==========================================================
 *                20. Valid Parentheses (Stack)
 * ========================================================== */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        // When encounter left parentheses, push corresponding right parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else if (ch == '(') {
                st.push(')');
            } else if (st.isEmpty() || st.peek() != ch) { // .isEmpty needs to be put in the front
                return false;
            } else {
                st.pop();
            }

            // System.out.println(ch);
        }

        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}

// TC: 0(N); SC: O(N)

/* ==========================================================
 *          21. Merge Two Sorted Lists (Linked List)
 * ========================================================== */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}

// TC: O(M + N); SC: O(1) -> Do not use additional space