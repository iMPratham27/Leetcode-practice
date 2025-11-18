import java.util.*;

class LongestSubstringWithKDistinctChars {
    
    static int longestDistinctSubstring(String s, int k){
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for(int end=0; end<s.length(); end++){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }

            while(map.size() > k){
                char left = s.charAt(start);
                map.put(left, map.get(left)-1);
                if(map.get(left) == 0) map.remove(left);

                start++;
            }

            if(map.size() == k){
                maxLen = Math.max(maxLen, end-start+1);
            }
        } 
        return maxLen;
    }

    public static void main(String[] args) {
        
        String s = "thisisalongx";
        int k = 4;
        int ans = longestDistinctSubstring(s, k);
        System.out.println(ans);
    }
}
