package uniqueNumberOfOccurences;

import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1 );
        }
        Set<Integer> set = new HashSet<>(); 
        for(int value : map.values()){
            if(!set.add(value)) return false; //如果存储失败，则表明已经有这个数了，则false； 
        }

        return true; 


    }
}
