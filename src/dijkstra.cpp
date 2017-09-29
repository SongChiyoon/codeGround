//
//  dijkstra.cpp
//  practice
//
//  Created by 송치윤 on 2017. 9. 29..
//  Copyright © 2017년 송치윤. All rights reserved.
//

#include "dijkstra.hpp"
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <queue>
#include <functional>
using namespace std;

struct EDGE{
    int target;
    int cost;
};
long mmax = 1000000;
struct NODE{
    
    int name;
    long cost = mmax;
    vector<EDGE> edge_list;
};
struct relu{
    
    bool operator()(NODE a, NODE b){
        return a.cost > b.cost;
    }
};


int main(){
    
    string file = "/Users/songchiyun/Library/Mobile Documents/com~apple~CloudDocs/Desktop/project/c++/practice/read2.txt";
    ifstream fr(file.data());
    int N, M;
    fr >> N >> M;
    vector<NODE> node(N+1);
    for(int i=1;i<=N;i++)
        node[i].name = i;
    int source;
    fr >> source;
    
    for(int i=0;i<M;i++){
        int s, t, cost;
        fr >> s >> t >> cost;
        EDGE e1, e2;
        e1.target = s; e2.target = t;
        e1.cost = e2.cost = cost;
        node[s].edge_list.push_back(e2);
        //node[t].edge_list.push_back(e1);
    }
    priority_queue<NODE, vector<NODE>, relu> pq;
    node[source].cost = 0;
    pq.push(node[source]);
    while(!pq.empty()){
        
        NODE a = pq.top();
        pq.pop();
        for(int i=0;i<a.edge_list.size();i++){
            EDGE e = a.edge_list[i];
            if(node[e.target].cost > a.cost + e.cost){
                node[e.target].cost = a.cost + e.cost;
                pq.push(node[e.target]);
            }
        }
    }
    for(int i=1;i<=N;i++){
        if(node[i].cost == mmax)
            cout << "INF" << endl;
        else
            cout << node[i].cost << endl;
    }
    
    
    
    
}
