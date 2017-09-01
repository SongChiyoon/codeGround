import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 2..
 * problem : https://www.acmicpc.net/problem/1699
 */
public class square_sum {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		int high = 2;
		for(int i=2;i<=N;i++){
			
			if(i == Math.pow(high, 2)){
				high++; 
				dp[i] = 1;
				continue;
			}
			int min = Integer.MAX_VALUE;
			for(int j=1;j<high;j++){
				int h = (int)Math.pow(high-j, 2);
				min = Math.min(min, dp[h] + dp[i-h]);
			}
			dp[i] = min;			
		}

		System.out.println(dp[N]);
	}
}
