import java.util.*;

class CarFleet {

    private static int carFleet(int target, int position[], int speed[]){

        int n = position.length;
        double cars[][] = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i]; // time
        }

        // sort acc to starting position 
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0])); 

        Stack<Double> s = new Stack<>();
        for(int i=0; i<n; i++){
            
            double time = cars[i][1];
            if(!s.isEmpty() && time <= s.peek()){
                continue;
            }
            s.push(time);
        }

        return s.size();
    }

    public static void main(String[] args) {
        
        int position[] = {10,8,0,5,3};
        int speed[] = {2,4,1,1,3};
        int target = 12;

        int ans = carFleet(target, position, speed);
        System.out.println(ans);
    }
}