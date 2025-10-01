class ValidAnagram {

    private static boolean isAnagram(String s, String t){

        if(s.length() != t.length()) return false;

        int arr[] = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr['z'-ch]++;
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            arr['z'-ch]--;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        String s = "anagram";
        String t = "nagaram";

        boolean check = isAnagram(s, t);
        System.out.println(check);
    }
}