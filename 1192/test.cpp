#include <bits/stdc++.h>
using namespace std;

//DFS找无向图中的桥
class edge
{
public:
    int next;
    int to;
    edge(int _to, int _next)
    {
        to = _to;
        next = _next;
    }
};
class Solution
{
public:
    vector<vector<int>> res;
    edge *edges[200002];
    int head[100002];
    //bool vis[100002];
    int now = 0;
    stack<int> nodestack;
    unordered_map<int, int> path;
    void insertEdge(int from, int to)
    {
        edges[now] = new edge(to, head[from]);
        head[from] = now++;
    }

    int dfs(int node, int depth)
    {
        int father;
        if (nodestack.empty())
            father = -1;
        else
            father = nodestack.top();
        nodestack.push(node);
        //vis[node]=true;
        path[node] = depth;
        int ancentdepth = depth;
        for (int next = head[node]; next != -1; next = edges[next]->next)
        {
            int to = edges[next]->to;
            if (to == father)
                continue;
            if (path.count(to))
                ancentdepth = min(ancentdepth, path[to]);
            else
            {
                ancentdepth = min(ancentdepth, dfs(to, depth + 1));
            }
        }
        //see if node have path to his ancent;
        nodestack.pop();
        //if(node==1)cout<<depth<<" "<<ancentdepth;
        if (ancentdepth == depth && !nodestack.empty())
        {
            vector<int> mid;
            mid.push_back(node);
            mid.push_back(nodestack.top());
            res.push_back(mid);
        }
        //path.erase(node);
        return ancentdepth;
    }
    vector<vector<int>> criticalConnections(int n, vector<vector<int>> &connections)
    {
        memset(head, -1, sizeof(head));
        //memset(vis,false,sizeof(vis));
        //build the graph
        for (vector<int> temp : connections)
        {
            insertEdge(temp[0], temp[1]);
            insertEdge(temp[1], temp[0]);
        }
        //dfs find the bridge
        dfs(0, 0);
        return res;
    }
};
