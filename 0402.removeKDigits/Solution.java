class Solution {
    public String removeKdigits(String num, int k) {
        //删掉特殊情况
        if(num.length() == k){
            return "0";
        }
        char[] s = num.toCharArray(); //这里是把 num 放进 char 数组 s
        Stack<Character> stack = new Stack<>();

        //遍历数组
        for(Character i : s){
            //移除元素的情况, k-- 
            //数字应该尽量在高位，则当前位小于前一位时，对前一位出栈，当前位入栈
            while(!stack.isEmpty() && i < stack.peek() && k > 0){
                stack.pop();
                k--; 
            }

            //栈为空，且当前位为0时， 我们不需要将其入栈
            if(stack.isEmpty() && i == '0'){
                continue; 
            }
            stack.push(i);
        }
        while(k > 0){
            stack.pop();
            k--;
        }

        //这个是最后栈为空时，删除一位，比如我们的10，删除一位为0，按上面逻辑我们会返回""，所以我们让其返回"0"
        if(stack.isEmpty()){
            return "0";
        }

        //反转并返回字符串
        StringBuilder str = new StringBuilder(); 
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString(); 


    }
}