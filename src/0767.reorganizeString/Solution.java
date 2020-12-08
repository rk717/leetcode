class Solution {
    // 定义了新的数据结构，存储字母和它的出现次数
    private class Letter{
        char ch;
        int count;
        public Letter(int count,char ch){
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String reorganizeString(String S) {
        StringBuilder res = new StringBuilder();
        int[] counter = new int[26];
        // 初始化最大堆
        PriorityQueue<Letter> pq = new PriorityQueue<Letter>(
            new Comparator<Letter>(){
                public int compare(Letter l1,Letter l2){
                    return l2.count - l1.count;
                }
            }
        );

        // 统计字母出现的次数
        for(int i = 0;i < S.length();i++){
            counter[S.charAt(i) - 'a']++;
        }

        // 遍历哈希表
        for(int i = 0;i < 26;i++){
            // 边界条件
            if(counter[i] > (S.length()+1)/2)
                return "";

            // 将字母添加到堆中
            if(counter[i] > 0)
                pq.offer(new Letter(counter[i],(char)(i+'a')));
        }
        
        Letter prev = new Letter(0,' ');
        
        // 开始重构字符串
        while(!pq.isEmpty()){
            Letter cur = pq.peek();
            pq.poll();
            res.append(cur.ch);
            
            if(prev.count > 0)
                pq.offer(prev);
            prev = new Letter(cur.count-1,cur.ch);
        }
        
        return res.toString();
    }
}