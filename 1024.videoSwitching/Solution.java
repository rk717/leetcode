package videoSwitching;

public class Solution {
    public int videoStitching(int[][] clips, int T){
        if(clips == null){
            return 0; 
        }

        //maxEnd, to store the current number maximun ending index
        int[] maxEnd = new int[T]; 

        //traverse clips, initial maxEnd array. 
        for(int[] clip : clips){
            if(clip[0] < T){
                maxEnd[clip[0]] = Math.max(maxEnd[clip[0]], clip[1]);
            }
        }

        int pre = 0; //store the last elements biggest ending index
        int last = 0; //store current elements biggest ending index
        int count = 0; //get the result 

        for(int i = 0; i < T; i++){
            last = Math.max(maxEnd[i], last);
            if(i == last){ //current element == this range biggest element, can't move on
                return -1; 
            }

            if(i == pre){ //current element == last element biggest element
                count++;
                pre = last;
            }
        }
        return count; 
    }
}
