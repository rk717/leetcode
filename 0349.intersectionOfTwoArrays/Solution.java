import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import jdk.internal.jline.internal.Ansi;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setn = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            setn.add(nums1[i]);
        }

        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(setn.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }

        int[] ans = new int[res.size()];

        int count = 0; 
        for(Integer i : res){
            ans[count++] = i; 
        }
        return ans; 
    }
}