package reverseInteger;

import java.util.ArrayList;

public class Solution {
    public int reverse(int x){
        int rev = 0;
        while(x != 0){
            //take the last element of number 
            int tmp = x % 10; 
            //decide whether its bigger than the 32 bit 
            if(rev > 214748364 || (rev == 214748364 && tmp > 7)){
                return 0; 
            }
            //decide whether its smaller than the 32 bit
            if(rev < -214748364 || (rev == -214748364 && tmp < -8)){
                return 0;
            }
            rev = rev*10 + tmp; 
            x /= 10;
        }
        return rev; 
    }
}
