import java.util.*;

class AllAnagramsInString {

    private static List<Integer> findAnagrams(String s, String p){

        List<Integer> result = new ArrayList<>();

        int pFreq[] = new int[26];
        for(char ch: p.toCharArray()){
            pFreq[ch-'a']++;
        }

        int sFreq[] = new int[26];
        int start = 0;
        int windowLength = p.length();
        for(int end=0; end<s.length(); end++){

            sFreq[s.charAt(end)-'a']++;

            if(end-start+1 > windowLength){
                sFreq[s.charAt(start)-'a']--;
                start++;
            }

            if(Arrays.equals(sFreq, pFreq)) result.add(start);
        }

        return result;
    }

    public static void main(String[] args){

        String s = "abab";
        String p = "ab";

        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
     }
}