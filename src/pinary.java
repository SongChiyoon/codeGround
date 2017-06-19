import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class pinary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[91];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);

    }
}
