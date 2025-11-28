import java.util.*;

class KthLargestInArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i: nums){
            minHeap.offer(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int arr[] = {3,2,3,1,2,4,5,5,6};
        int k=4;

        int ans = findKthLargest(arr, k);
        System.out.println(ans);
    }
}
