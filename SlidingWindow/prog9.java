
import java.util.*;

class MinimumWindowSubString {

    private static String minWindow(String s, String t){

        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()){
            if(tMap.containsKey(c)){
                tMap.put(c, tMap.get(c)+1);
            }else{
                tMap.put(c, 1);
            }
        }

        int start = 0, end = 0;
        int required = tMap.size();
        int formed = 0;
        int ans[] = {-1, 0, 0}; // {length, start, end}
        Map<Character, Integer> windowMap = new HashMap<>();
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(windowMap.containsKey(c)){
                windowMap.put(c, windowMap.get(c)+1);
            }else{
                windowMap.put(c, 1);
            }

            if(tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()){
                formed++;
            }

            while(start<=end && formed == required){
                // update ans
                if(ans[0] == -1 || end-start+1 < ans[0]){
                    ans[0] = end-start+1;
                    ans[1] = start;
                    ans[2] = end;
                }

                // shrink
                char ch = s.charAt(start);
                if(windowMap.containsKey(ch)){
                    windowMap.put(ch, windowMap.get(ch)-1);
                }
                if(tMap.containsKey(ch) && windowMap.get(ch).intValue() < tMap.get(ch).intValue()){
                    formed--;
                }
                start++;
            }

            end++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
    
    public static void main(String[] args) {
        
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);
        System.out.println(result);

    }
}
