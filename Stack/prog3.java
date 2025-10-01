
import java.util.*;

class EvaluteRPN {

    private static int evalRPN(String tokens[]){

        Stack<Integer> s = new Stack<>();

        for(String c: tokens){
            if(c.equals("+")){
                
                int second = s.pop();
                int first = s.pop();
                s.push(first+second);
            
            }else if(c.equals("-")){

                int second = s.pop();
                int first = s.pop();
                s.push(first-second);

            }else if(c.equals("*")){

                s.push(s.pop() * s.pop());

            }else if(c.equals("/")){

                int second = s.pop();
                int first = s.pop();
                s.push(first/second);

            }else{
                s.push(Integer.parseInt(c));
            }
        }

        return s.peek();
    }
    
    public static void main(String[] args) {
        
        String tokens[] = {"2","1","+","3","*"};

        int ans = evalRPN(tokens);
        System.out.println(ans);
    }
}
