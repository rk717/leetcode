//https://leetcode-cn.com/problems/maximum-gap/solution/java-tong-pai-xu-by-smitish/

//桶排序
/*
这里用桶排序，只用考虑桶间的排序，不用考虑桶内的排序
用后一个桶的最小值 减 前一个桶的最大值，可以得到最大间距。 
*/

class Solution{
    //线性时间复杂度和空间复杂度 不能用Arrays.sort 
    public int maximumGap(int[] nums){
        if(nums.length < 2) return 0;
        int len = nums.length; 

        //找出最大值和最小值，为了方便后面确定桶的数量
        int max = -1; 
        int min == Integer.MAX_VALUE; 
        for(int i = 0; i < len; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min); 
        }

        //排除nums全部为一样的数字, nums = [1,1,1,1,1,1];
        int (max - min == 0) return 0; 

        //用于存放每个桶的最大值
        int[] bucketMin = new int[len-1];

        //用于存放每个桶的最小值
        int[] bucketMax = new int[len-1];

        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        //确定桶的间距
        int interval = (int)Math.ceil((double)(max-min) / (len-1));
        for(int i = 0; i < len; i++){
            //找到每一值对应桶的索引
            int index = (nums[i] - min) / interval; 
            if(nums[i] == min || nums[i] == max) continue; 

            //更新每个桶的数据
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
        }

        //maxGap 表示桶之间最大的差距
        int maxGap = 0; 

        //preMax 表示一个桶的最大值
        int preMax = min; 
        for(int i = 0; i < len-1; i++){
            //表示某一个桶为空
            //但凡一个桶不为空， 都会在前面的数据中更新掉bucketMax的值
            if(bucketMax[i] == -1) continue; 
            maxGap = Math.max(bucketMin[i] - preMax, maxGap);
            preMax = bucketMax[i];
        }

        //[1, 1000000]
        maxGap = Math.max(maxGap, max - preMax);
        return maxGap; 
    }
}