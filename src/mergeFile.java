import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 14..
 */
public class mergeFile {

    int[][] d;
    int[] a;
    int N;
    mergeFile(int[][] d, int[] a, int N){
        this.d = d;
        this.a = a;
        this.N = N;
    }
    public int go(int i, int j){
        if(i == j) return 0;
        if(d[i][j] != -1) return d[i][j];

        for(int k = i; j <= j-1; j++){
            d[i][j] = go(i,k) + go(k+1, j) + sum(i, j);
        }
        return d[i][j];

    }
    private int sum(int i , int j){
        int sum = 0;
        for(int k = i; k <= j; k++)
            sum += a[k];
        return sum;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){

            int N = sc.nextInt();
            int[] a = new int[N+1];
            for(int j = 1; j<= N; j++)
                a[j] = sc.nextInt();
            int[][] d = new int[N+1][N+1];
            for(int k = 1; k <= N; k++)
                for(int j = 1; j <= N; j++)
                    d[k][j] = -1;
            mergeFile solution = new mergeFile(d,a,N);
            System.out.println(solution.go(1, N));

        }
    }
}
