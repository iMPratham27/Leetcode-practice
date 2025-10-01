
class LongestRepeatingCharReplace {

    private static int characterReplacement(String s, int k){

        int maxLen = 0;
        int maxFreq = 0;
        int freqCount[] = new int[26];
        int start = 0;

        for(int end=0; end<s.length(); end++){

            int index = s.charAt(end) - 'A';
            freqCount[index]++;

            maxFreq = Math.max(maxFreq, freqCount[index]);

            // charReplace = windowlength - maxFreq => charReplace > k => shrink the window
            while(((end-start+1) - maxFreq) > k){
                freqCount[s.charAt(start)-'A']--;
                start++;
            }

            maxLen = Math.max(maxLen, (end-start+1));
        }

        return maxLen;
    }

    public static void main(String[] args){

        String s = "AABABBA";
        int k = 1;

        int maxlen = characterReplacement(s, k);
        System.out.println(maxlen);
    }
}