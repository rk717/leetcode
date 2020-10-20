package twoSum;

import java.util.Map;

// 1 . Violent enumeration
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         //delcare an array of integers
//         int[] arr = new int[2]; 
//         for(int i = 0; i < nums.length; i++)
//         {
//             for(int j = i + 1; j < nums.length; j++){
//                 if(nums[i] + nums[j] == target){
//                     arr[0] = i; 
//                     arr[1] = j; 
//                 }
//             }
//         }
//         return arr; 

//     }
// }

// 2 . hash map 

class Solution {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            if(hashtable.containsKey(target - nums[i])){
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}