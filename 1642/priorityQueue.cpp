#include <bits/stdc++.h>
using namespace std; 

/*
priority_queue is like a normal queue except the element removed from 
the queue is always the greatest among all the elements in the queue, 
thus this container is usually used ot replicate MAX Heap cpp.  

*/

int main() {
    priority_queue<int> pq1; 

    pq1.push(30); //inserts 30 to pq1, now top = 30 
    pq1.push(40); //inserts 40 to pq1, now top = 40 (max element)
    pq1.push(90); //insert 90 to pq1, now top = 90 
    pq1.push(60);  // insert 60 to pq1, top is still is 90 
    

    return 0; 
}