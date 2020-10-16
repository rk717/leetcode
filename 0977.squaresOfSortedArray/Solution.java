package squaresOfSortedArray;

import java.util.*;
import java.lang.Math;

public class Solution {  
    public static int[] sortedSquares(int[] A){
        int[] newa = new int[A.length];

        for(int i = 0; i < A.length; i++){
            newa[i] = (int) Math.pow(A[i], 2);
        }
        
        Arrays.sort(newa);

        return newa; 
    }

    public static void main(String[] args) {
        int[] ar = {-4,-1,0,3,10}; 
        
        ar = sortedSquares(ar);
        for(int i = 0; i < ar.length; i++){
            System.out.println(ar[i]);
        }
    }
}

//977
