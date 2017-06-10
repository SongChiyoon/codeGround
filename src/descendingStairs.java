import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 14..
 */
public class descendingStairs {

    int[][] d;
    int[][] a;
    int N, M;

    descendingStairs(int[][] d, int[][] a, int N, int M){
        this.d = d;
        this.a = a;
        this.N = N;
        this.M = M;
    }

    public int go(int i, int j){

        if(i == N && j == M)
            return 1;

        if(d[i][j] > 0 ){
            return d[i][j];
        }

        if(i-1 >= 1 && a[i][j] > a[i-1][j])
            d[i][j] += go(i-1, j);

        if(i+1 <= N && a[i][j] > a[i+1][j])
            d[i][j] += go(i+1, j);

        if(j-1 >=1 && a[i][j] > a[i][j-1])
            d[i][j] += go(i, j-1);

        if(j+1 <= M && a[i][j] > a[i][j+1])
            d[i][j] += go(i, j+1);

        return d[i][j];


    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] d = new int[N+1][M+2];
        int[][] a = new int[N+1][M+2];

        for(int i = 0; i <= N; i++){

            for(int j = 0; j <= M+1; j++){

                if(i == 0 || j == 0){
                    a[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if(j == M+1){
                    a[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                a[i][j] = sc.nextInt();
            }
        }
        descendingStairs solution = new descendingStairs(d,a, N, M);
        System.out.println(solution.go(1,1));
    }
}
