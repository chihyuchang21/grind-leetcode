public class Solution {
    public String simplifyPath(String path) {
        // Split the path by '/' to get individual components
        String[] components = path.split("/");

        // Stack to keep track of valid directories
        Stack<String> stack = new Stack<>();

        // Iterate over each component of the path
        for (String component : components) {
            // If the component is ".." and the stack is not empty, pop the stack
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // If the component is valid (not empty, not ".", not ".."), push it to the stack
            else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        // Construct the simplified path from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack is empty, return the root directory "/"
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }
}
