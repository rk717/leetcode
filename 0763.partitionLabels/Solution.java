package partitionLabels;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<Integer> partitionLables(String S){ //"ababcbacadefegdehijhklij"
        ArrayList<Integer> result = new ArrayList<>();
        if(S == null || S.length() <= 0){
            return result; 
        }

        //put the value into the 'lastIndex' array
        int[] lastIndex = new int[26]; //store one letter last occurance index
        Arrays.fill(lastIndex, -1);
        int length = S.length();   //lastIndex = [-1, -1, -1, -1, ...]
        
        for(int i = 0; i < length; i++){
            lastIndex[S.charAt(i) - 'a'] = i; 
        }

        /*
            S.charAt(0) = 'a' 
            lastIndex[0] = i = 0

            S.charAt(1) = 'b'
            lastIndex['b' - 'a'] = i = 1

            S.charAt(2) = 'a'
            lastIndex['a' - 'a'] = i = 2
            
            lastIndex = [0, 1, ]
            lastIndex = [2, 1, ]

            
        */


        //calculate the array value 
        int startIndex = 0; 
        int endIndex = 0; 
        for(int i = 0; i < length; i++){
            //get the max index now
            endIndex = Math.max(endIndex, lastIndex[S.charAt(i) - 'a']);
            if(i == endIndex){ //if equal, then the elements before, only exist before i, we can put it in the record
                result.add(endIndex - startIndex + 1); 
                startIndex = endIndex + 1; 

            } 
        }
        return result; 
    }
}
