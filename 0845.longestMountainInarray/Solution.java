package longestMountainInarray; 

class Solution {
    public static int longestMountain(int[] A) {
        int p = 0; 
        int cur = 1; 
        int max = 0; 
        while(p < A.length - 1){
            cur = 1; 
            while( p < A.length - 1 && A[p] < A[p + 1]){
                cur++;
                p++;
            }

            if(cur == 1){
                p++;
                continue; 
            }

            int t = cur; 

            while(p < A.length - 1 && A[p] > A[p + 1]){
                cur++;
                p++;
            }

            if(cur == t){
                p++;
                continue; 
            }

            if(cur >= 3) max = Math.max(cur, max);

        }
        return max; 
    }

    

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 4, 7, 3, 2, 5};
        int resl = 0; 
        resl = longestMountain(arr);
        System.out.println(resl);
    }
}