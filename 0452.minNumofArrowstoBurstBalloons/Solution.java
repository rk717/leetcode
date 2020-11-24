import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length <= 0){
            return 0;
        }

        int result = 1;
        Arrays.sort(points, (point1, point2) -> {
            if(point1[1] > point2[1]){
                return 1;
            }else if(point1[1] < point2[1]) {
                return -1;
            }else{
                return 0;
            }
        });
        //according to the first start place,
        //sort the array in ascending way
        
        //greedy algorithm
        int curEnd = points[0][1];
        for(int i = 0; i < points.length; i++){
           if(points[i][0] > curEnd){
           	result++;
           	curEnd = points[i][1];
           }   
        }
        
        return result; 
    }
}