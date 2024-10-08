class Solution {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1; // num1 的最後一位
        int j = num2.length() - 1; // num2 的最後一位
        int carry = 0; // 初始進位為 0

        // 從後往前逐位加，直到所有位數處理完，並且沒有進位
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = 0;
            int digit2 = 0;

            // 如果 i 未超出範圍，取 num1 的當前位數，否則視為 0
            if (i >= 0) {
                digit1 = num1.charAt(i) - '0';
            }

            // 如果 j 未超出範圍，取 num2 的當前位數，否則視為 0
            if (j >= 0) {
                digit2 = num2.charAt(j) - '0';
            }

            int sum = digit1 + digit2 + carry; // 當前位數相加
            carry = sum / 10; // 計算進位
            result.append(sum % 10); // 保留個位數

            i--; // 移動到 num1 的前一位
            j--; // 移動到 num2 的前一位
        }

        return result.reverse().toString(); // 因為是從後往前加的，最後需要反轉
    }

}