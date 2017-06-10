import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class detachSticker {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] result = new int[T+1];
        for(int t = 1; t <= T; t++){

            int N = sc.nextInt();

            int[][] dp = new int[N+1][3];
            int[][] a = new int[3][N+1];

            for(int i = 1; i <= 2; i++){
                for(int j = 1; j <= N; j++){
                    a[i][j] = sc.nextInt();
                }
            }

            dp[1][0] = 0;
            dp[1][1] = a[1][1];
            dp[1][2] = a[2][1];
            for(int i = 2; i <= N; i++){
                for(int j = 0; j <= 2; j++){
                    dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1], dp[i-1][2]));
                    dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + a[1][i];
                    dp[i][2] = Math.max(dp[i-1][0],dp[i-1][1]) + a[2][i];
                }
            }
            result[t] = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));

        }
        for(int i = 1; i <= T; i++)
            System.out.println(result[i]);
    }
}
