
import java.util.*;

class LongestSubstringWithoutRepeatingChar {

    private static int lengthOfLongestSubstring(String s){

        Set<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        
        for(int end=0; end<s.length(); end++){

            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }

            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}