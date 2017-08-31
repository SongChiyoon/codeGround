import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 31..
 * problem : https://www.acmicpc.net/problem/1003
 */
public class fibonacci_count {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			
			int[][] dp = new int[40][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			int N = sc.nextInt();
			if(N == 0 || N == 1){
				System.out.println(dp[N][0] +" "+dp[N][1]);
				continue;
			}
			for(int i=2;i<=N;i++){
				
				dp[i][0] += dp[i-1][0] + dp[i-2][0];
				dp[i][1] += dp[i-1][1] + dp[i-2][1];
			}
			System.out.println(dp[N][0] +" "+dp[N][1]);		
		}
	}
}
