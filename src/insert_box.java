import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 2..
 * problem : https://www.acmicpc.net/problem/1965
 */
public class insert_box {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N];
		int[] n = new int[N];
		for(int i=0;i<N;i++)
			n[i] = sc.nextInt();
		int max=Integer.MIN_VALUE;
		dp[0] = 1;
		for(int i=1;i<N;i++){
			
			for(int j=i-1;j>=0;j--){
				
				if(n[i] > n[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
					
				}
			}
			if(dp[i] == 0)
				dp[i] = 1;

			max = Math.max(max, dp[i]);
			
		}

		System.out.println(max);
		
	}
}
