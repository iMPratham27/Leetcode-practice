import java.util.Arrays;

class PermutationStrings {

    private static boolean checkInclusion(String s1, String s2){

        if(s1.length() > s2.length()) return false;

        int s1Freq[] = new int[26];
        for(char ch: s1.toCharArray()){
            s1Freq[ch-'a']++;
        }

        int s2Freq[] = new int[26];
        int windowLength = s1.length();
        int start = 0;
        for(int end=0; end<s2.length(); end++){

            s2Freq[s2.charAt(end)-'a']++;

            if(end-start+1 > windowLength){
                s2Freq[s2.charAt(start)-'a']--;
                start++;
            }

            if(Arrays.equals(s1Freq, s2Freq)) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean ans = checkInclusion(s1, s2);
        System.out.println(ans);
    }
}