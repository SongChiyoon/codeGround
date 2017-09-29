//
//  under_X.cpp
//  practice
//
//  Created by 송치윤 on 2017. 9. 29..
//  Copyright © 2017년 송치윤. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <fstream>
#include <queue>
#include <functional>
#include <string>
#include <vector>

using namespace std;
int main(){
    
    string file = "/Users/songchiyun/Library/Mobile Documents/com~apple~CloudDocs/Desktop/project/c++/practice/read2.txt";
    
    ifstream fr(file.data());
    
    int N, S;
    fr >> N >> S;
    vector<int> v;
    int num;
    for(int i=0;i<N;i++){
        fr >> num;
        if(num <S)
            v.push_back(num);
        
    }
    
    for(int i=0;i<v.size();i++){
        cout<<v[i] << " ";
    }
    cout << endl;
    
    
    return 0;
}
