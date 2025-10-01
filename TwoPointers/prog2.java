import java.util.Arrays;

class TwoSum2 {

    private static int[] twoSum(int nums[], int target){

        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right] == target){
                return new int[]{left+1, right+1};
            }

            if(nums[left]+nums[right] > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{};
    }
    
    public static void main(String[] args){

        int nums[] = {-1,0};
        int target = -1;

        int result[] = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
