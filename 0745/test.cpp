#include <bits/stdc++.h>

using namespace std; 

class Trie {
private:
    //数组初始化只有全为0才能这样写
    Trie* arc[27]={NULL};
    int val=0;
public:
    /** Initialize your data structure here. */
    Trie(){}
    
    /** Inserts a word into the trie. */
    void insert(string &word,int start,int _val) {
        Trie* p=this;
        int size=word.size();
        for (int i=start;i<size;++i)
        {
            int index= word.at(i)=='#' ? 26 : word.at(i)-'a';
            if (p->arc[index]==NULL)
                p->arc[index]=new Trie;
            p=p->arc[index];
            p->val=max(p->val,_val);
        }
    }
    
    int search(string &word) {
        Trie* p=this;
        int size=word.size();
        for (int i=0;i<size;++i)
        {
            int index= word.at(i)=='#' ? 26 : word.at(i)-'a';
            if (p->arc[index]==NULL)
                return -1;
            else
                p=p->arc[index];
        }
        return p->val;
    }
};
class WordFilter {
    Trie trie;
public:
    WordFilter(vector<string>& words) {
        int words_size=words.size();
        string s;
        for (int i=0;i<words_size;++i)
        {
            s=words.at(i)+"#"+words.at(i);
            int words_i_size=words.at(i).size();
            for (int j=0;j<=words_i_size;++j)
                trie.insert(s,j,i);
        }
    }
    
    int f(string prefix, string suffix) {
        string target=suffix+"#"+prefix;
        return trie.search(target);
    }
};

/*

作者：LZH_Yves
链接：https://leetcode-cn.com/problems/prefix-and-suffix-search/solution/zi-dian-shu-by-lzh_yves/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/