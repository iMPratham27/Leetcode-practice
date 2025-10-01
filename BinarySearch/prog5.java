class SearchInRotatedSortedArr {

    private static int search(int nums[], int target){

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1; // target in left half
                } else {
                    start = mid + 1; // target in right half
                }
            } 
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1; // target in right half
                } else {
                    end = mid - 1; // target in left half
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;

        int ans = search(nums, target);
        System.out.println(ans);
    }
}
