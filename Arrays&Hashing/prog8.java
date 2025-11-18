import java.util.*;

class FirstUniqueChar {
    
    static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(freqMap.containsKey(s.charAt(i))){
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))+1);
            }else{
                freqMap.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i<s.length(); i++){
            if(freqMap.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        String s = "aabb";
        int ans = firstUniqChar(s);
        System.out.println(ans);
    }
}
