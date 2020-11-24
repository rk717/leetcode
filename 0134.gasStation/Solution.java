class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length <= 0 || cost == null || cost.length <= 0){
            return -1; 
        }

        int length = gas.length;
        int[] profile = new int[length];

        int curCost = 0; //用于存储 “到达该站的总花费汽油”
        int curSumCost = 0; //用于存储从 出发点 到 当前站的 总花费汽油
        int totalCost = 0; //用于存储 全段路线 的 总花费汽油
        int startIndex = 0; //用于存储 当前出发点的下标

        for(int i = 0; i < length; i++){
            curCost = cost[i] - gas[i];
            curSumCost += curCost;
            totalCost += curCost;

            //若当前汽油花费 > 0 （表示当前出发点不能实现 走遍环路）
            //重置 当前开始下标 和 当前总花费汽油

            if(curSumCost > 0){
                startIndex = i+1; 
                curSumCost = 0; 
            }
        }
        return totalCost <= 0 ? startIndex : -1; 
    }
}

// gas  = [1,2,3,4,5]
// cost = [3,4,5,1,2]
