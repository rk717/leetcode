class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //将两个数两个数的相加结果按照出现次数录入一个map中
        //再遍历另外两个数组，将相加结果的相反数，在map中查找，若找到，则结果+=出现次数
        int result = 0; 

        HashMap<Integer, Integer>memory = new HashMap<>();
        int curNum; 
        for(int a : A){
            for(int b : B){
                curNum = a + b; 
                if(memory.containsKey(curNum)){
                    memory.put(curNum, memory.get(curNum) + 1);
                }else{
                    memory.put(curNum, 1);
                }
            }
        }
        for(int c : C){
            for(int d : D){
                curNum = -(c + d);
                if(memory.containsKey(curNum)){
                    result += memory.get(curNum);
                }
            }
        }
        return result; 
    }
}