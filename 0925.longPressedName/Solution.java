package longPressedName;


public class Solution {
    public boolean isLongPressedName(String name, String typed){
        if(name.length() == 0 && typed.length() == 0){
            return true; 
        }
        else if(name.length() == 0 || typed.length() == 0){
            return false; 
        }

        int i = 0, j = 0; 
        while(i < name.length() || j < name.length()){
            if(i < name.length() && j < typed.length() && 
                name.charAt(i) == typed.charAt(j)){
                    i++;
                    j++;
                }
            else{
                if(j > 0 && j < typed.length() &&
                    typed.charAt(j) == typed.charAt(j-1)){
                        j++;
                    }else{
                        return false;
                    }
            }
            
        }
        return i == name.length() && j == typed.length(); 
    }

    public static void main(String[] args) {
        
    }
}
