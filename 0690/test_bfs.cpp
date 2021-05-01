#include <bits/stdc++.h>

using namespace std; 

class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};

class Solution {
public:
    int getImportance(vector<Employee *> employees, int id) {
        unordered_map<int, Employee *> mp;
        for (auto &employee : employees) {
            mp[employee->id] = employee;
        }

        int total = 0;
        queue<int> que;
        que.push(id);
        while (!que.empty()) {
            int curId = que.front();
            que.pop();
            Employee *employee = mp[curId];
            total += employee->importance;
            for (int subId : employee->subordinates) {
                que.push(subId);
            }
        }
        return total;
    }
};