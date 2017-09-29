#include <iostream>
#include <queue>
using namespace std;

int d[50][50];
bool v[50][50];
struct Coor {
	int y, x;
};

int main() {

	int T, N, M, K;
	cin >> T;
	for (int t = 0; t < T; t++) {

		cin >> M >> N >> K;
		for (int k = 0; k < K; k++) {
			int x, y;
			cin >> x >> y;
			d[y][x] = 1;

		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (d[i][j] == 1 && !v[i][j]) {
					ans++;
					queue<Coor> q;
					Coor c;
					c.y = i; c.x = j;
					v[i][j] = true;
					q.push(c);

					while (!q.empty()) {
						Coor a = q.front();
						q.pop();
						int x = a.x;
						int y = a.y;
						if (x - 1 >= 0)if( d[y][x - 1] == 1 && !v[y][x - 1]) {
							Coor add;
							add.x = x - 1; add.y = y;
							v[y][x - 1] = true;
							q.push(add);
						}
						if (x + 1 < M)if( d[y][x + 1] == 1 && !v[y][x + 1]) {
							Coor add;
							add.x = x + 1; add.y = y;
							v[y][x + 1] = true;
							q.push(add);
						}
						if (y - 1 >= 0)if( d[y - 1][x] == 1 && !v[y - 1][x]) {
							Coor add;
							add.x = x; add.y = y - 1;
							v[y - 1][x] = true;
							q.push(add);
						}
						if (y + 1 < N)if(d[y + 1][x] == 1 && !v[y + 1][x]) {
							Coor add;
							add.x = x; add.y = y + 1;
							v[y + 1][x] = true;
							q.push(add);
						}

					}


				}

			}

		}
        
		cout << ans << "\n";
        
		for(int i=0;i<N;i++)
            
			for (int j = 0; j < M; j++) {
				d[i][j] = 0;
				v[i][j] = false;
			}
	}

	return 0;

}
