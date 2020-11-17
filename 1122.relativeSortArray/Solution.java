class Solution{
    public int[] relativeSortArray(int[] arr1, int[] arr2){
        //为了节省内存，我们先把数组1的最大值找到，好节省哈希表内存
        int max = 0; 
        for(int i = 0; i < arr1.length; i++){
            if(max < arr1[i]){
                max = arr1[i];
            }
        }

        //记得加1， 不然会索引超出范围 
        int[] hat = new int[max+1]; 

        //哈希排序
        for(int item = 0; item < arr1.length; item++){
            hat[ arr1[item] ]++; 
        }

        //建立数组1的索引，方便后面展开哈希表中的数据
        int arr1Index = 0; ;

        //建立数组2的索引， 将数据放入数组1
        for(int item = 0; item < arr2.length; item++){
            for(; hat[ arr2[item] ] !=0; hat[ arr2[item] ]--){
                arr1[arr1Index] = arr2[item];
                arr1Index++; 
            }
        }

        //不用我们就扔掉
        arr2 = null;

        //前面数据已经处理完毕，直接展开表中数据
        for(int item = 0; item < hat.length; item++){
            if(hat[item] != 0){
                for(int i = 0; i < hat[item]; i++){
                    arr1[arr1Index] = item; 
                    arr1Index++;
                }
            }
        }

        //删除hat，减少占用内存
        hat = null; 
        return arr1; 
    }
}


// class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         int[] memory = new int[1001];

//         //将arr1 中的元素，根据 下标 和 出现次数 录入 结果数组
//         int length = arr1.length; 
//         int[] result = new int[length];
//         for(int i = 0; i < length; i++){
//             memory[arr1[i]]++; 
//         }


//         //将arr2 中存在的数组 按照arr2中的顺序 录入结果数组
//         int index = 0; 
//         for(int i = 0; i < arr2.length; i++){
//             while(memory[arr2[i]] > 0){
//                 result[index++] = arr2[i]; 
//                 memory[arr2[i]]--; 
//             }
//         }

//         //将不存在 arr2 中的 数字， 录入结果数组
//         for(int i = 0; i < 1001; i++){
//             while(memory[i] > 0){
//                 result[index++] = i; 
//                 memory[i]--; 
//             }
//         }
//         return result; 
//     }
// }