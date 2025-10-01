import java.util.*;

class LongestConsecutiveSeq {

    private static int longestConsecutive(int nums[]) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        int nums[] = { 100, 4, 200, 1, 3, 2 };

        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }
}

