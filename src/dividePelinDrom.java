import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 14..
 */
public class dividePelinDrom {

    private char[] a;
    private int[][] d;
    private int[] dp;
    private int N;
    dividePelinDrom(char[] a, int[][] d, int[] dp, int N){

        this.a = a;
        this.d = d;
        this.dp = dp;
        this.N = N;
    }
    public int go(int i , int j){
        if(i == j) return 1;
        if(i+1 == j){
            if(a[i] == a[j]) return 1;
            else return -1;
        }
        if(d[i][j] == -1 || d[i][j] == 1){
            return d[i][j];
        }
        if(a[i] != a[j]) return d[i][j] = -1;

        d[i][j] = go(i+1, j -1);
        return d[i][j];
    }

    public void makeD(){

        for(int i = 1; i <= N; i++){
            for(int j = i; j <= N; j++){
                d[i][j] = go(i,j);

            }

        }
        System.out.println(d[1][2]);

    }

    public int getDp(){
        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            if(i != 1)
                dp[i] = -1;

            for(int j = 1; j < i; j++){

                if(d[j][i] == 1){
                    if(dp[i] == -1) {
                        dp[i] = dp[j - 1] + 1;
                        continue;
                    }
                    else{
                        if(dp[i] > dp[j-1]+1)
                            dp[i] = dp[j-1]+1;
                    }
                }
            }

            if(dp[i] == -1){
                dp[i] = dp[i-1] + 1;
            }

        }for(int i = 1; i <= N; i++)
            System.out.print(dp[i] + " ");

        return dp[N];
    }
    public int getDp2(){
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            if(i != 1)
                dp[i] = -1;

            for(int j = 1; j <= i; j++){

                if(d[j][i] == 1){
                    if(dp[i] == -1 || dp[i] > dp[j-1] + 1){
                        dp[i] = dp[j-1]+1;
                    }
                }
            }

        }
        for(int i = 1; i <= N; i++)
            System.out.print(dp[i] + " ");

        return dp[N];
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int N = input.length();
        int[][] d;
        int[] dp;
        char[] c = new char[N+1];
        d = new int[N+1][N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            c[i] = input.charAt(i-1);
        }

        dividePelinDrom solution = new dividePelinDrom(c,d,dp,N);
        solution.makeD();
        System.out.println(solution.getDp());
        System.out.println(solution.getDp2());
    }
}
