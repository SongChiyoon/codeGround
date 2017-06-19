import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class fishBread {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1001];
        int N = sc.nextInt();
        int[] p = new int[N+1];

        for(int i=1;i<=N;i++)
            p[i] = sc.nextInt();

        dp[1] = p[1];
        dp[2] = Math.max(p[2], 2*dp[1]);
        for(int i = 3; i <= N; i++){
            if(i % 2 !=0 ){
                dp[i] = Math.max(p[i], dp[i-1] + dp[1]);
            }
            else{
                dp[i] = Math.max(p[i], Math.max(dp[i-2]*2, dp[i-1] + dp[1]));
            }
        }
        System.out.println(dp[N]);
    }
}
