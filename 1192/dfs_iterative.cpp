#include <iostream>
#include <stack>
#include <list>
#include <vector>
using namespace std; 

class Graph {
    int V; //no. of vertices; 
    list<int>* adj;  //adjacency list

public:
    Graph(int V); //constructor
    void addEdge(int v, int w); //to add an edge to graph
    void DFS(int s); //pritns all vertices in DFS manner
    //from a given source; 
};

Graph::Graph(int V) {
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w) {
    adj[v].push_back(w); //add w to v's list. 
}


//prints all not yet visited vertives reachable from s 
void Graph::DFS(int s) {
    //initially mark all vertices as not visited 
    vector<bool> visited(V, false); 

    //create a stack for DFS
    stack<int> stack;

    //push the current source node
    stack.push(s); 

    while(!stack.empty()) {
        //pop a vertex from stack and print it
        s = stack.top(); 
        stack.pop(); 

        //stack may contain same vertex twice, so we 
        //need to print the popped item only 
        //if it is not visited 
        if(!visited[s]) {
            cout << s << " ";
            visited[s] = true; 
        }

        //get all adjacent vertices of the popped vertex s 
        //if a adjacent has not been visited, then push it to the satck.
        for(auto i = adj[s].begin(); i != adj[s].end(); ++i)
            if(!visited[*i])
                stack.push(*i); 
    }
}

// Driver program to test methods of graph class
int main()
{
    Graph g(5); // Total 5 vertices in graph
    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(1, 4);
 
    cout << "Following is Depth First Traversal\n";
    g.DFS(0);
 
    return 0;
}