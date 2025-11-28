import java.util.*;

class KClosestPointsToOrigin {
    
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                b[0]*b[0] + b[1]*b[1],
                a[0]*a[0] + a[1]*a[1]
            )
        );

        for(int p[]: points){
            maxHeap.offer(p);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int result[][] = new int[k][2];
        for(int i=0; i<k; i++){
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        int result[][] = kClosest(arr, k);
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}
