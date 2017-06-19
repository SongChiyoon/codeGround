import java.util.Scanner;

public class Division {
	private int[][] d;
	private int[] a;
	private int N;
	private int M;
	Division(int[][] d, int[] a, int N, int M){
		this.d = d;
		this.a = a;
		this.N = N;
		this.M = M;
	}
	public int go(int i, int j){
		
		if(i == j) return a[i];
		
		if(i > j) return 0;
	
		if(d[i][j] != 0) return d[i][j];
		
		d[i][j] = go(i+1, j-1) + a[i] + a[j];
		
		return d[i][j];
	}
	public int[] division(int M, int[][] k){
		
		int max = Integer.MIN_VALUE;
		int[] dp = new int[M];
		k[0][0] = 1;
		k[0][1] = N - (M-1);
		for(int i = 1; i < M; i++){
			
			k[i][0] = i;
			k[i][1] = N - (M - i - 1);
		}
		
		for(int ki = 0; ki < M; ki++){
			for(int i = k[ki][0]; i <= k[ki][1]; i++){
				dp[ki] = Math.max(dp[ki], d[k[ki][0]][i]);
			}
		}
		return dp;
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N+1];
		int[][] d = new int[N+1][N+1];
		
		int M = sc.nextInt();
		for(int i = 1; i <= N; i++){
			a[i] = sc.nextInt();
		}
		Division solution = new Division(d,a,N, M);
		
		solution.go(1, N);
		
		int[][] k = new int[M][2];
		
		int[] result = solution.division(M, k);
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < M; i++){
			System.out.println(result[i]);
			max = Math.max(max, result[i]);
		}
		System.out.println(max);

		
	}
}
