class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length <= 1){
            return people; 
        }

        /*
            按照 如下规则，给数组排序：
                若两人身高相等，将 p[1]小的 排在前面(这样才能保证 后面的p[1]条件满足)
                若两人身高不等，将 身高高的 排在前面
         */

        Arrays.sort(people, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]; 
        });

        
    }
}