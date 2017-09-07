import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 7..
 * problem : https://www.acmicpc.net/problem/2631
 */
public class make_line {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		int[] d= new int[N+1];
		for(int i=1;i<=N;i++){
			d[i] = sc.nextInt();
			dp[i] = 1;
		}
		for(int i=1;i<=N;i++){
			
			for(int j=i-1;j>=1;j--){
				if(d[i] > d[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				
			}
			System.out.print(dp[i] +" ");
		}
		System.out.println();
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++)
			max = Math.max(dp[i],max);
		System.out.println(N-max);
	}
}
