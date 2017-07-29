import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 29..
 *  * https://www.acmicpc.net/problem/2447

 */
public class drawStar {
    static char[][] d;
    public static void print(Object o){System.out.print(o);}
    public static void println(Object o){System.out.println(o);}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        d = new char[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                d[i][j] = '*';
        drawStar(0,0,N);
        Result(N);

    }
    public static void Result(int N){
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++)
                print(d[i][j]);
            print('\n');
        }
    }
    public static void drawStar(int x, int y, int N){
        if(N == 1){
            return;
        }
        int m = N/3;
        for(int i=0;i<m;i++)
            for(int j=0;j<m;j++)
                d[y+m+i][x+j+m] = ' ';
        drawStar(x,y,m);
        drawStar(x+m,y,m);
        drawStar(x+2*m,y,m);
        drawStar(x, y+m, m);
        drawStar(x+2*m,y+m,m);
        drawStar(x, y+2*m, m);
        drawStar(x+m, y+2*m, m);
        drawStar(x+2*m, y+2*m, m);

    }

}
