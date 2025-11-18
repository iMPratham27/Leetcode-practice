class RansomNote {

    static boolean canConstruct(String ransomeNote, String magzine){

        int counter[] = new int[26];
        for(int i=0; i<magzine.length(); i++){
            char ch = magzine.charAt(i);
            counter[ch-'a']++;
        }

        for(int i=0; i<ransomeNote.length(); i++){
            char ch = ransomeNote.charAt(i);
            counter[ch-'a']--;
            if(counter[ch-'a'] < 0) return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        
        String ransomeNote = "aa";
        String magazine = "ab";

        boolean ans = canConstruct(ransomeNote, magazine);
        System.out.println(ans);
    }
}
