class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1; 

        int[] result = new int[A.length]; 

        for(int a : A){
            if (a%2 == 0){
                result[i] = a; 
                i+=2; 
            }else{
                result[j] = a; 
                j+=2; 
            }
        }
        return result; 
    }
}