
class MaxAvgSubArray {

    private static double findMaxAverage(int nums[], int k){

        double avg = (double)Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        for(int end=0; end<nums.length; end++){
            sum += nums[end];

            if(end-start+1 == k){
                avg = Math.max(avg, (double)sum/k);

                sum -= nums[start];
                start++;
            }
        }
        return avg;
    }

    public static void main(String[] args){

        int nums[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double avg = findMaxAverage(nums, k);
        System.out.println(avg);
    }
}