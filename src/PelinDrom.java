import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PelinDrom{
	private int[] a;
	private int[][] dp;
	private int N;
	PelinDrom(int[] a, int N){
		this.a = a;
		this.dp = new int[N+1][N+1];
	}
	public int getResult(int s, int d){
		if(s == d)
			return 1;
		if(s+1 == d) {
			if(a[s] == a[d])
				return 1;
			else
				return -1;
		}
		if(a[s] != a[d]) return dp[s][d] = -1;
		if(dp[s][d] == 1 || dp[s][d] == -1) return dp[s][d];

		dp[s][d] = getResult(s+1,d-1);

		return dp[s][d];

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int N = sc.nextInt();


		int[] a = new int[N+1];

		for (int i = 1; i <= N; i++)
			a[i] = sc.nextInt();

		PelinDrom solution = new PelinDrom(a, N);

		int Qnum = sc.nextInt();

		int s, b;
		int[] result = new int[Qnum];
		for (int i = 0; i < Qnum; i++) {

			s = sc.nextInt();
			b = sc.nextInt();
			int output = solution.getResult(s,b);
			if(output == -1)
				output = 0;
			System.out.println(output);

		}

	}
}
