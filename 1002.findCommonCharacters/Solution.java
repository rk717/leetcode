package findCommonCharacters;

import java.util.*; 

public class Solution {
    public List<String> commonChars(String[] A){
        //create string ArrayList
        ArrayList<String> st1 = new ArrayList<String>();

        //create a int array [26], and fill with the max value
        int[] arr1 = new int[26];
        Arrays.fill(arr1, Integer.MAX_VALUE);
        
        //for loop to traverse the String A
        for(String curr_s : A){
            int[] check_fre = new int[26];

            for(char c : curr_s.toCharArray()){
                check_fre[c-'a']++; 
            }
            //now we know all the letters frequency 

            //we should put them with arr1(min_frequency)
            //why we can't just use check_fre, because check_fre is 
            //in the for loop, we can't use it outside, we have to 
            //put it vaue to the 'arr1' which is outside the loop.
            for(int i = 0; i < 26; i++){
                arr1[i] = Math.min(arr1[i], check_fre[i]);                
            }//now we have the min frequency
            
        }

        //lets put the min frequency letter to st1
        for(int i = 0; i < 26; i++){
            while(arr1[i] > 0){
                st1.add("" + (char)(i+'a'));
                arr1[i]--; 
            }
        }

        return st1; 
         
    }
}


//1002