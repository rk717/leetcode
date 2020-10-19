//reconstruct the string

/*
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str){
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for(int i = 0; i < length; ++i){
            char ch = str.charAt(i);
            if(ch != '#'){
                ret.append(ch);
            }else{
                if(ret.length() > 0){
                    ret.deleteCharAt(ret.length()-1);
                }
            }
        }
        return ret.toString(); 
    }
}
*/

//two pointer

class Soultion{
    public boolean backspaceCompare(String S, String T){
        if(S == null || T == null){
            return false; 
        }

        /*
        from back to begining 
        1. traverse S / traverse T
            1.if we meet '#', then use sWell++, to keen the amount, and let the pointer move
            2.if not '#', but sWell still bigger than 0, 
                (it means) we still have letter which not beeen erased yet,
                just erase this index letter, and move pointer.
            3.if both up 2 points are not satisfied anymore, then continue to the next
        2. traverse T, same above
        3. compare now S and T, if not equl, return false
        4. repete the loop above, until one string has finished traverse

        */

        int sWell = 0; //keep '#' number in String S
        int tWell = 0; //keep '#' number in String T
        int indexS = S.length() - 1; 
        int indexT = T.length() - 1; 
        while(indexS >= 0 || indexT >= 0){
            // 1. traverse S / traverse T
            // 1.if we meet '#', then use sWell++, to keen the amount, and let the pointer move
            // 2.if not '#', but sWell still bigger than 0, 
            //     (it means) we still have letter which not beeen erased yet,
            //     just erase this index letter, and move pointer.
            // 3.if both up 2 points are not satisfied anymore, then continue to the next
            while(indexS >= 0){
                if(S.charAt(indexS) == '#'){
                    sWell++;
                    indexS--;
                }else if(sWell > 0){
                    sWell--;
                    indexS--;
                }else{
                    break;
                }
            }

            //traverse String T, same as above
            while(indexT >= 0){
                if(T.charAt(indexT) == '#'){
                    tWell++;
                    indexT--;
                }else if(tWell > 0){
                    tWell--;
                    indexT--;
                }else{
                    break; 
                }
            }

            //compare String S and String T, if not same, return false
            if(indexS >= 0 && indexT >= 0)
            {
                if(S.charAt(indexS) != T.charAt(indexT)) 
                {
                    return false; 
                }
            }
            else
            {
                if(indexS >= 0 || indexT >= 0)
                {
                    return false; 
                }
            }
            indexS--;
            indexT--; 
            
            
        }
        return true; 
    }
}