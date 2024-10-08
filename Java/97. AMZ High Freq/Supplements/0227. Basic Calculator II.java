class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+'; // The operation before the current number
        s = s.replaceAll(" ", ""); // Remove any spaces

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                // Update the operation and reset the current number
                operation = currentChar;
                currentNumber = 0;
            }
        }

        // Sum up all the numbers in the stack
        int result = 0;
        for (int num : stack) {
            result += num;
        }

        return result;
    }
}
