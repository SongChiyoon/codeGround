#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;
int N, S;
int ans = 0;
vector<int> v;
void subset(int current, int sum, bool pass) {
	if (!pass && sum == S) {
		ans += 1;
	}
	if (current < N - 1) {
		subset(current + 1, sum + v[current + 1], false);
		subset(current + 1, sum, true);
	}

}
int main() {

	//t N, S;
	cin >> N >> S;
	v.resize(N);
	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;
		v[i] = num;
	}
	for (int i = 0; i < N; i++) {
		subset(i, v[i], false);
	}
	cout << ans << "\n";
	int a;
	cin >> a;
}
