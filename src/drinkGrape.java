import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class drinkGrape {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N+1];
        int[][] dp = new int[N+1][2];

        for(int i = 1; i <= N; i++)
            a[i] = sc.nextInt();

        dp[1][0] = 0;
        dp[1][1] = a[1];

        dp[2][0] = Math.max(dp[1][0], dp[1][1]);
        dp[2][1] = Math.max(dp[1][0] + a[2], dp[1][1] + a[2]);

        for(int i = 3; i <= N; i++){

            dp[i][0] = Math.max(dp[i-2][0]+a[i-1], dp[i-2][1] + a[i-1]);
            dp[i][1] = Math.max(dp[i-2][0]+a[i], Math.max(dp[i-2][1]+a[i], dp[i-2][0]+a[i-1]+a[i]));

        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
