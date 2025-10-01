
import java.util.*;

class SlidingWindowMaximum {

    private static int[] maxSlidingWindow(int nums[], int k){

        int n = nums.length;
        int result[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){

            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k-1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int result[] = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
