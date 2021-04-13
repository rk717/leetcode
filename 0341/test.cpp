/*
you are given a nested list of integers nestedList.
each element is either an integer or a list 
or a list whose elements may also be integers or other lists. 
inplement an iterator to flattern it. 
*/

#include <iostream>
#include <vector>

using namespace std; 
class NestedInteger {
public:
    //return true if this NestedInteger holds a single integer, rather than a nested list
    bool isInteger() const; 

    //return the single integer that this NestedInteger holds, 
    //if it holds a nested list
    int getInteger() const; 

    //return the nested list that this NestedInteger holds, if it holds a nested list
    const vector<NestedInteger>& getList() const; 
};

class NestedIterator {
public: 
    vector<int> res; 
    int cnt = 0; 

    NestedIterator(vector<NestedInteger>& nestedList) {
        //initializes the iterator with the nested list nestedList
        dfs(nestedList);
    }

    void dfs(vector<NestedInteger>& nestedList) {
        for( auto t : nestedList) {
            if(t.isInteger()) {
                res.push_back(t.getInteger());
            } else {
                dfs(t.getList());
            }
        }
    }

    int next() {
        //return the next integer in the nested list
        return res[cnt++];
    }

    bool hasNext() {
        //return true if there are still some integers in the nested list and false otherwise
        return cnt < res.size();

    }


};
