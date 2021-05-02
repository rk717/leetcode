#include <bits/stdc++.h>

using namespace std; 

bool cmp(vector<int>& l, vector<int>& r) {
    return l[1] < r[1]; 
}
    
class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        sort(courses.begin(), courses.end(), cmp); 

        priority_queue<int> qu; 
        int day = 0; 
        for(int i = 0; i < courses.size(); i++) {
            if(day + courses[i][0] <= courses[i][1]) {
                qu.push(courses[i][0]);
                day += courses[i][0];
            } else {
                qu.push(courses[i][0]);
                day += courses[i][0];

                int mostwastecourse = qu.top(); 
                qu.pop(); 
                day -= mostwastecourse;
            }
        }
        return qu.size();
    }
};