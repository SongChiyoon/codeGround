import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 4. 13..
 */
public class Jump {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] b = new int[N+2][N+2];
        int[][] d = new int[N+2][N+2];
        for(int i = 0 ; i <= N; i++){
            b[i][0] = 0;
            b[0][1] = 0;
            d[i][0] = 0;
            d[0][i] = 0;
        }

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++) {
                d[i][j] = 0;
                b[i][j] = sc.nextInt();
            }

        d[1][1] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(b[i][j] == 0) continue;
                if(b[i][j] + i <= N)
                    d[i+b[i][j]][j] += d[i][j];
                if(b[i][j] + j <= N)
                    d[i][j+b[i][j]] += d[i][j];

            }
        }
        System.out.println(d[N][N]);



    }


}
