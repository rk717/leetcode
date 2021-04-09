#include <iostream>
#include <unordered_map>
#include <vector> 
#include <string>

using namespace std; 

class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        vector<int> hash(26);
        for(int i = 0; i < 26; ++i){
            hash[order[i] - 'a'] = i; 
        }

        for(int i = 0; i < words.size(); ++i) {
            for(int j = 0; j < i; ++j){
                int ret = check(hash, words[j], words[i]);
                if(ret > 0){
                    return false; 
                }
            }
        }
        return true; 
        

    }

    int check(const vector<int>& hash, const string& w1, const string& w2){
        int len = min(w1.size(), w2.size());
        for(int i = 0; i < len; ++i){
            if(hash[w1[i] - 'a'] < hash[w2[i] - 'a']){
                return -1; 
            }else if(hash[w1[i] - 'a'] > hash[w2[i] - 'a']){
                return 1; 
            }
           
        }    

        if(w1.size() < w2.size()){
            return -1; 
        }else if(w1.size() == w2.size()){
            return 0; 
        }else{
            return 1; 
        }
    }

};