
import java.util.*;

class MinStack {
    
    private Stack<int []> st; // [val, currMin]
    

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val, val});
        }else{
            int currMin = st.peek()[1];
            st.push(new int[]{val, Math.min(val, currMin)});
        }
    }
    
    public void pop() {
        st.pop();
        
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }

    public static void main(String[] args) {
        
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        int min1 = minStack.getMin(); 
        System.out.println(min1); // return -3
        
        minStack.pop();
        
        int topVal = minStack.top();    
        System.out.println(topVal); // return 0
        
        int min2 = minStack.getMin(); 
        System.out.println(min2); // return -2
    }
}
