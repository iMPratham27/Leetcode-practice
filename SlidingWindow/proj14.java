import java.util.*;

class FruitIntoBasket {
    static int totalFruit(int fruits[]){
        int maxFruits = Integer.MIN_VALUE;
        int buckets = 2;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int end=0; end<fruits.length; end++){
            int num = fruits[end];
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }

            while(map.size() > buckets){
                int left = fruits[start];
                map.put(left, map.get(left)-1);
                if(map.get(left) == 0) map.remove(left);

                start++;
            }

            maxFruits = Math.max(maxFruits, end-start+1);
        }
        return maxFruits;
    }
    
    public static void main(String[] args) {
        
        int fruits[] = {1,2,3,2,2};
        int ans = totalFruit(fruits);
        System.out.println(ans);
    }
}
