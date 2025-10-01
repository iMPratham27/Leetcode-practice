class MinSizeSubArraySum {

    private static int minSubArrayLen(int target, int nums[]){

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int end=0; end<nums.length; end++){

            sum += nums[end];

            while(start<=end && sum >= target){
                minLen = Math.min(minLen, end-start+1);

                sum -= nums[start];
                start++;
            }
        }

        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
    
    public static void main(String[] args) {
        
        int nums[] = {2,3,1,2,4,3};
        int target = 7;

        int minlen = minSubArrayLen(target, nums);
        System.out.println(minlen);
    }
}
