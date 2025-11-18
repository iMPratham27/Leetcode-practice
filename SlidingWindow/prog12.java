class MaximumVowelsInSubString {

    static int maxVowelsSubString(String s, int k){

        int maxVowels = 0;
        int start = 0;
        int count = 0;
        for(int end=0; end<s.length(); end++){
            if(isVowel(s.charAt(end))) count++;

            if(end-start+1 == k){
                maxVowels = Math.max(maxVowels, count);

                if(isVowel(s.charAt(start))) count--;

                start++;
            }
        }

        return maxVowels;
    }

    static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;

        return false;
    }
    
    public static void main(String[] args) {
        
        String s = "thisisalongx";
        int k = 4;

        int ans = maxVowelsSubString(s, k);
        System.out.println(ans);
    }
}