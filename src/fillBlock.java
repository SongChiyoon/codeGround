import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 10..
 */
public class fillBlock {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dp[] = new int[1001];
        int N;
        do{
            N = sc.nextInt();
        }while(N < 1 || N > 1000);

        dp[0] = 1;
        dp[1] = 1;
        for(int i =2; i <= N; i++ ){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 10007;
        }
        System.out.println(dp[N]);
    }
}
