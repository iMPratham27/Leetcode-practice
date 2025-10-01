import java.util.*;

class GroupAnagram {  

    private static List<List<String>> groupAnagrams(String[] strs){

        if(strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){

        String strs[] = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}