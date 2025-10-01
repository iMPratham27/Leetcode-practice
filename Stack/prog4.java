
import java.util.*;

class DailyTempratures {

    private static int[] dailyTempratures(int nums[]){

        // int n = nums.length;
        // int result[] = new int[n];

        // // Next bigger -> M D S -> bottom: big & top: small
        // Stack<Integer> s = new Stack<>(); 
        // Arrays.fill(result, 0);
        
        // for(int i=0; i<n; i++){

        //     while(!s.isEmpty() && nums[i] > nums[s.peek()]){
        //         int val = s.pop();
        //         result[val] = i-val;
        //     }
        //     s.add(i);
        // }

        // return result;


        int n = nums.length;
        int result[] = new int[n];
        int stack[] = new int[n];
        int top = -1;

        for(int i=0; i<n; i++){

            while(top>=0 && nums[i] > nums[stack[top]]){
                int val = stack[top];
                result[val] =  i - val;
                top--;
            }
            top++;
            stack[top] = i;
        }

        return result;
    }
    
    public static void main(String[] args) {
        
        int nums[] = {73,74,75,71,69,72,76,73};
        int result[] = dailyTempratures(nums);
        System.out.println(Arrays.toString(result));
    }
}
