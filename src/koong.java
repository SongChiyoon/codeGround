import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 7..
 * problem : https://www.acmicpc.net/problem/9507
 */

public class koong {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			int n = sc.nextInt();
			long[] dp = new long[68];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int i=4;i<=n;i++){
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
			}
			System.out.println(dp[n]);
		}
		
	}
	public static long ggoong(long n){
		if(n < 2){
			return 1;
		}
		else if(n == 2)
			return 2;
		else if(n == 3)
			return 4;
		else
			return (ggoong(n-1) + ggoong(n-2) + ggoong(n-3) + ggoong(n-4));
	}
}
