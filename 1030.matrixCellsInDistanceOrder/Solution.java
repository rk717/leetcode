class Solution{
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0){
        if( R <= 0 || C <= 0){
            return new int[0][0];
        }

        int[][] result = new int[R*C][2];

        int index = 0; 
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                result[index][0] = i; 
                result[index++][1] = j;
            }
        }

        Arrays.sort(result, (arr1, arr2) -> (Math.abs(arr1[0] - r0) +
            Math.abs(arr1[1] - c0)) - 
            (Math.abs(arr2[0] - r0) + Math.abs(arr2[1] - c0))
        );

        return result; 
    }
}