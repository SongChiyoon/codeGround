import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class addOneTwoThree {
    public static void main(String[] args){
        int T;
        int N;
        int[] result;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        result = new int[T];
        for(int i = 0;i < T; i++){
            N = sc.nextInt();
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j = 4; j <= N; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            result[i] = dp[N];

        }
        for(int i =0; i < T; i++)
            System.out.println(result[i]);
    }
}
