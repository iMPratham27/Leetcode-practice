import java.util.*;

class FirstNegativeInEveryWindow {

    private static List<Integer> firstNegInt(int nums[], int k) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int start = 0;
        for (int end = 0; end < nums.length; end++) {

            if (nums[end] < 0) {
                dq.addLast(end);
            }

            if (end - start + 1 == k) {

                if (!dq.isEmpty()) {
                    result.add(nums[dq.peekFirst()]);
                } else {
                    result.add(0);
                }

                if (!dq.isEmpty() && dq.peekFirst() == start) {
                    dq.pollFirst();
                }

                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        List<Integer> result = firstNegInt(nums, k);
        System.out.println(result);
    }
}

