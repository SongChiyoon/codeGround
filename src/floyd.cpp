/*
#include <iostream>
#include <vector>
using namespace std;
long maxx = 1000000;


int main() {

	int N;
	cin >> N;
	vector<vector<long>> d;
	d.resize(N + 1);
	for (int i = 0; i <= N; i++) {
		for (int j = 0; j <= N; j++) {
			if (i == j)
				d[i].push_back(0);
			else
				d[i].push_back(maxx);
		}
	}

	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {

		int s, t;
		int cost;
		cin >> s >> t >> cost;
		if(d[s][t] > cost)
			d[s][t] = cost;

	}
	

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= N; k++) {

				if (d[j][k] > d[j][i] + d[i][k]) {
					d[j][k] = d[j][i] + d[i][k];
				}
			}
		}
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (d[i][j] == maxx)
				d[i][j] = 0;
			cout << d[i][j] << " ";
		}
		cout << "\n";
	}
	
	int a;
	cin >> a;

	return 0;
}*/