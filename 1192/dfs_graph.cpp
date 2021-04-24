//cpp program to print dfs traversal from a given vertex in a given graph
#include <bits/stdc++.h>
using namespace std; 

//graph class represents a directed graph 
//using adjacency list representation 
class Graph{
public: 
    map<int, bool> visited; 
    map<int, list<int>> adj; 

    //function to add an edge to graph
    void addEdge(int v, int w); 

    //dfs traversal of the vertices 
    //reachable from v
    void DFS(int v); 
}; 

void Graph::addEdge(int v, int w) {
    adj[v].push_back(w); //add w to v's list 
}

void Graph::DFS(int v) {
    //mark the current node as visited and print it
    visited[v] = true; 
    cout << v << " "; 

    //recur for all the vertices adjacent to this vertex
    list<int>::iterator i; 
    for(i = adj[v].begin(); i != adj[v].end(); ++i) {
        if(!visited[*i]) {
            DFS(*i); 
        }
    }
}