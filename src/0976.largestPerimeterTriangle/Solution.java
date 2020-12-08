class Solution {
    public int largestPerimeter(int[] A) {
        if(A == null || A.length < 3){
            return 0; 
        }

        //排序数组 A
        Arrays.sort(A);

        //计算结果
        int curSum; 
        for(int i = A.length - 3; i >= 0; i--){
            curSum = A[i] + A[i + 1];
            if(curSum > A[i+2]){
                return curSum + A[i+2];
            }
        }
        return 0; 
    }
}