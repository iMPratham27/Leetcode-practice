import java.util.*;

class KthLargest {

    private int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        
        int arr[] = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(3,arr);

        int val1 = obj.add(3);
        int val2 = obj.add(5);
        int val3 = obj.add(10);
        int val4 = obj.add(9);
        int val5 = obj.add(4);

        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);
        System.out.println(val5);
    }
}
