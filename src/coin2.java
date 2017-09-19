import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 19..
 * problem : https://www.acmicpc.net/problem/2294
 */
public class coin2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] d = new int[n];
		int[] dp = new int[10000000];
		for(int i =0;i<n;i++){
			d[i] = sc.nextInt();
		}
		dp[k] = -1;
		Arrays.sort(d);
		
		for(int i = 0; i< n;i++){
		
			dp[d[i]] = 1;
			for(int j =1;j <= k;j++){
				
				if(dp[j] > 0){
					
					if(j + d[i] <= k){
						
						if(dp[j+d[i]] <= 0)
							dp[j+d[i]] = dp[j] + 1;
						else
							dp[j+d[i]] = Math.min(dp[j+d[i]], dp[j]+1);
					}
				}
				
			}
			
			
		}

		System.out.println(dp[k]);
		
	}
}
