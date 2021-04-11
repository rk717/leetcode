#include <iostream>
#include <queue>

using namespace std; 

//print the queue
void showq(queue<int> gq) {
    queue<int> g = gq; 
    while(!g.empty()) {
        cout << '\t' << g.front(); 
        g.pop(); 
    }
    cout << '\n';
}

//driver code 
int main() {
    queue<int> gquiz; 
    gquiz.push(10); 
    gquiz.push(20); 
    gquiz.push(30); 

    cout << "the queue gquiz is: ";
    showq(gquiz); 

    cout << "size" << gquiz.size(); 
    cout << "front" << gquiz.front(); 
    cout << "back" << gquiz.back(); 

    cout << "gquiz pop : \n";
    gquiz.pop(); 
    showq(gquiz); 



    return 0; 
}