class RandomizedCollection {

    List<Integer> list;
     Map<Integer,Set<Integer>> idx;
 
     /** Initialize your data structure here. */
     public RandomizedCollection() {
         list = new ArrayList<>();
         idx = new HashMap<>();
     }
     
     /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
     public boolean insert(int val) {
         Set<Integer> idx_set = idx.getOrDefault(val, new HashSet<>());
         //将元素添加到List的末尾
         list.add(val);
         //更新Hash中的索引值
         idx_set.add(list.size()-1);
         idx.put(val, idx_set);
         //如果List中已经包含了val值，那此时val值对应的Hash表的大小肯定大于1
         return idx_set.size()==1;
     }
     
     /** Removes a value from the collection. Returns true if the collection contained the specified element. */
     public boolean remove(int val) {
         if(idx.get(val)==null){
             return false;
         }
         int last_idx = list.size()-1;
         Iterator<Integer> iterator = idx.get(val).iterator();
         int delete_idx = iterator.next();
         iterator.remove(); //删除保存在set中的待删除元素的索引
         //如果待删除元素和最后一个元素相同，则直接删除
         //不相同则用最后一个元素覆盖待删除元素，并更新索引
         if(last_idx==delete_idx){
             list.remove(last_idx);
         }else{
             int value = list.get(last_idx);
             //覆盖待删除元素
             list.set(delete_idx, list.get(last_idx));
             list.remove(last_idx);
             //更新索引
             idx.get(value).remove(last_idx);
             idx.get(value).add(delete_idx);
         }
         //如果待删除元素的索引集合为空，直接删除索引集合
         if(!iterator.hasNext()){
             idx.remove(val);
         }
         return true;
     }
     
     /** Get a random element from the collection. */
     public int getRandom() {
           return list.get((int) (Math.random() * list.size()));
     }
 }
 
 /**
  * Your RandomizedCollection object will be instantiated and called as such:
  * RandomizedCollection obj = new RandomizedCollection();
  * boolean param_1 = obj.insert(val);
  * boolean param_2 = obj.remove(val);
  * int param_3 = obj.getRandom();
  */
 
 作者：zzzzzz-54
 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/solution/si-lu-shu-li-ji-dai-ma-o1shi-jian-cha-ru-shan-chu-/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。