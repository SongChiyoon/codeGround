import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 30..
 * problem : https://www.acmicpc.net/problem/2167
 */
public class sum_of_2dArray {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dp = new int[N+1][M+1];
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++){
				dp[i][j] = sc.nextInt();
				if(j != 0)
					dp[i][j] += dp[i][j-1];
			}
		
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int sy = sc.nextInt();
			int sx = sc.nextInt();
			int ty = sc.nextInt();
			int tx = sc.nextInt();
			int ans = 0;
			for(int j=sy; j<=ty; j++){
				ans += dp[j][tx];
				ans -= dp[j][sx-1];

			}
			System.out.println(ans);
		}
	}
}
