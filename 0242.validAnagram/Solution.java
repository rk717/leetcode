class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null && s != t){
            return false;
        }

        int slength = s.length();
        int tlength = t.length();
        if(slength != tlength){
            return false;
        }

        //record the letters appear in s string and their times
        int[] letters = new int[26];
        for(int i = 0; i < slength; i++){
            char curChar = s.charAt(i);
            letters[curChar - 97]++;
        }

        //record the letters appear in t string and their times
        for(int i = 0; i < tlength; i++){
            char curChar = t.charAt(i);
            letters[curChar - 97]--;
        }

        //determine if t and s has some deviation
        for(int letter : letters){
            if(letter != 0){
                return false;
            }
        }
        return true; 
    }
}