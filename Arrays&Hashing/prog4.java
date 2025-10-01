import java.util.*;

class TopKFreqElem {

    private static int[] topkFrequent(int nums[], int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        // Create buckets
        List<Integer> buckets[] = new List[nums.length+1];
        for(int num: map.keySet()){
            int freq = map.get(num);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // Collect top k
        List<Integer> result = new ArrayList<>();
        for(int i=buckets.length-1; i>=0 && result.size()<k; i--){
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }

        // Convert to array
        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = result.get(i);
        }

        return ans;

    }

    public static void main(String[] args){

        int nums[] = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;

        int result[] = topkFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}