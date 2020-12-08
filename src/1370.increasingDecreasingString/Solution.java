class Solution{
    public String sortString(String s){
        if(s == null || s.length() <= 0){
            return s; 
        }

        int[] memory = new int[26];
        int length = s.length();
        for(int i = 0; i < length; i++){
            memory[s.charAt(i) - 'a']++;
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < length; i++){
            for(int j = 0; j < 26; j++){
                if(memory[j] != 0){
                    str.append((char)(j+'a'));
                    memory[j]--;
                }
            }

            for(int j = 25; j >= 0; j--){
                if(memory[j] != 0){
                    str.append((char)(j+'a'));
                    memory[j]--;
                }
            }
        }
        return str.toString();
    }
}