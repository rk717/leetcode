class Solution {
    public boolean validMountainArray(int[] A) {
        //可以使用两种指针，一个从左边找最高山峰，一个从右边找最高山峰，最后判断找到的是不是同一个山峰
        int len = A.length;
        int left = 0; 
        int right = len -1; 

        //从左边往右边找，一直找到山峰为止
        while(left + 1 < len && A[left] < A[left + 1]){
            left++;
        }

        //从右边往左边找，一直找到山峰为止
        while(right > 0 && A[right - 1] > A[right] ){
            right--; 
        }

        //判断左边和右边找到的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right; 



    }
}