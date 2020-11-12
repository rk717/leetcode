class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //使用快速选择（快排变形）获取points数组中距离最小的k个点，
        //第四个参数是下标，因此是 K-1
        return quickSelect(points, 0, points.length - 1, K - 1);
    }

    private int[][] quickSelect(int[][] points, int lo, int hi, int idx){
        if(lo > hi){
            return new int[0][0];
        }
        //快排切分后, j 左边的点距离都小于等于 points[j], j 右边的点距离都大于 points[j]
        int j = partition(points, lo, hi); 
        //如果j  正好等于目标 idx， 说明当前 points数组中的 [0, idx] 就是 距离最小的 K 个元素
        if(j == idx){
            return Arrays.copyOf(points, idx+1); 
        }
        //否则根据 j 与 idx 的大小关系 判断找 左端 还是 右端
        return j < idx ? quickSelect(points, j+1, hi, idx) : quickSelect(points, lo, j - 1, idx); 
    }

    private int partition(int[][] points, int lo, int hi){
        int[] v = points[lo];
        int dist = v[0] * v[0] + v[1] * v[1]; 
        int i = lo, j = hi + 1; 
        while(true){
            while(++i <= hi && points[i][0] * points[i][0] + points[i][1] * points[i][1] < dist);
            while(--j >= lo && points[j][0] * points[j][0] + points[j][1] * points[j][1] > dist);

            if( i >= j){
                break; 
            }

            int[] tmp = points[i];
            points[i] = points[j];
            points[j] = tmp; 
        }
        points[lo] = points[j]; 
        points[j] = v; 
        return j; 
    }

}