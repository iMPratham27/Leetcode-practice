class prog8 {

    // here nums[i] is the next pointer in the linked list
    // duplicate -> there must be a cycle as there are two same nums[i]

    private static int findDuplicate(int nums[]){
        int slow = nums[0];
        int fast = nums[0];

        // checks if cycle is present
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // finds the starting point of cycle
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
    
    public static void main(String[] args) {
        
        int nums[] = {1,3,4,2,2};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }
}
