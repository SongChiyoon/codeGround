import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class ascendingNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp;
        dp = new int[1001][10];

        for(int i = 0; i <= 9; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){

                dp[i][j] = 0;

                for(int k = 0; k <= j; k++){

                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %=  10007;
                }
            }
        }
        int result = 0;
        for(int i = 0; i <= 9; i++)
            result += dp[N][i];
        System.out.println(result);
    }
}
