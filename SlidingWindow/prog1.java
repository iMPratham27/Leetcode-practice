import java.util.*;

class MaximumSumSubarray {

    private static long maximumSubarraySum(int nums[], int k){
        long maxSum = 0;
        long windowSum = 0;
        int start = 0;

        Set<Integer> set = new HashSet<>();

        for(int end=0; end<nums.length; end++){

            int curr = nums[end];
            while(set.contains(curr)){
                set.remove(nums[start]);
                windowSum -= nums[start];
                start++;
            }

            set.add(curr);
            windowSum += curr;

            if(end-start+1 == k){
                maxSum = Math.max(maxSum, windowSum);

                set.remove(nums[start]);

                windowSum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        
        int nums[] = {1,5,4,2,9,9,9};
        int k = 3;

        long maxSum = maximumSubarraySum(nums, k);
        System.out.println(maxSum);
    }
}
