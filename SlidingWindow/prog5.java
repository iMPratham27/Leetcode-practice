
import java.util.*;

class DistinctElementsInEveryWindow {

    private static List<Integer> countDistinct(int arr[], int k){

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int start = 0;
        for(int end=0; end<arr.length; end++){

            if(map.containsKey(arr[end])){
                map.put(arr[end], map.get(arr[end])+1);
            }else{
                map.put(arr[end], 1);
            }


            if(end-start+1 == k){
                result.add(map.size());

                if(map.containsKey(arr[start])) map.put(arr[start], map.get(arr[start])-1);

                if(map.get(arr[start]) == 0) map.remove(arr[start]);

                start++;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        List<Integer> result = countDistinct(arr, k);
        System.out.println(result);
    }
}
