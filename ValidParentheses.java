import java.util.Stack;

public  class ValidParentheses {
    //assingment link: https://leetcode.com/problems/valid-parentheses/description

    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // If it's an opening bracket, push it onto the stack
                stack.push(c);
            } else {
                // If it's a closing bracket, check if the stack is empty or if it matches
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, it means all brackets are matched correctly
        return stack.isEmpty();
    }


    // Testing the snippet
    public static void main(String[] args) {
        // Testing using given string
        String inputString="([)]";
        boolean result = isValid(inputString); 
        // Print the result int
        System.out.println(result); 
    }
}

