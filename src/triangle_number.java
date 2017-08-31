import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 31..
 * problem : https://www.acmicpc.net/problem/1932
 */
public class triangle_number {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N][N];
		
		for(int i =0;i<N;i++){
			if(i == 0){
				dp[0][0] = sc.nextInt();
				continue;
			}
			for(int j=0;j<=i;j++){
				int a = sc.nextInt();
				if(j == 0){
					dp[i][j] = a+dp[i-1][0];
					continue;
				}
				
				else if(j == i)
					dp[i][j] = a+dp[i-1][j-1];
				else{
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + a;
				}
			}
			
			
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			max = Math.max(max, dp[N-1][i]);
		}
		System.out.println(max);
	}
}
