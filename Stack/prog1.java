
import java.util.*;

class ValidParenthesis {

    private static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        if(s.isEmpty()) return false;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }else{
                
                if(stack.isEmpty()) return false;

                char top = stack.peek();
                if(top == '[' && c == ']' || top == '(' && c ==')' || top == '{' && c == '}'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        
        String s = "[]";

        boolean ans = isValid(s);
        System.out.println(ans);
    }
}
