import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 10..
 *
 * BAEKJOON 11052번문제
 */
public class fishBread {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1001];
        int[] p;
        int N = sc.nextInt();
        p = new int[N+1];
        for(int i=1;i<=N;i++){
            p[i] = sc.nextInt();
            if(i%2 ==0){
                p[i] = Math.max(p[i], p[i/2]*2);
            }
        }
        dp[1] = p[1];
        for(int i=2;i<=N;i++){
            dp[i] = p[i];
            for(int j =1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[N]);

    }
}
