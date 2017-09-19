import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 19..
 * problem : https://www.acmicpc.net/problem/1890
 */
public class jump_dp {
	static int[][] dp;
	static int[][] d;
	static int n;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n][n];
		dp = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				d[i][j] = sc.nextInt();
				dp[i][j] = 0;
			}
		}
		dp[0][0] = 1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(d[i][j] == 0)
					continue;
				if(j+d[i][j] <= n-1)
					dp[i][j+d[i][j]] += dp[i][j];
				
				if(i+d[i][j] <= n-1)
					dp[i+d[i][j]][j] += dp[i][j];
				
			}
			
			
		}
		
		System.out.println(dp[n-1][n-1]);
	}
}
