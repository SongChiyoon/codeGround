import java.util.*;

/**
 * Created by songchiyun on 2017. 8. 10..
 * 문제 : https://www.acmicpc.net/problem/2583
 */
public class findRegion {

    static class coord{
        int y,x;
        coord(int x, int y){
            this.y = y;
            this.x = x;
        }
    }
    static int[][] d;
    static boolean[][] v;
    static int M, N;
    static List<Integer> result;
    static int num;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //세로
        N = sc.nextInt(); //가로
        int T = sc.nextInt();

        d = new int[M][N];
        v = new boolean[M][N];

        for(int t=0;t<T;t++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int i=x1;i<x2;i++)
                for(int j=M-y1-1;j>=M-y2;j--)
                    d[j][i] = 1;
        }
        result = new LinkedList<>();

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){

                if(d[i][j] != 1 && !v[i][j]){
                    num = 1;
                    v[i][j] = true;
                    dfs(j,i);
                    result.add(num);
                }

            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int size : result){
            System.out.print(size +" ");
        }


    }
    public static void dfs(int x, int y){

        if(x-1>=0){
            if(d[y][x-1] != 1 && !v[y][x-1]){
                v[y][x-1] = true;
                num++;
                dfs(x-1,y);
            }
        }
        if(x+1<N){
            if(d[y][x+1] != 1 && !v[y][x+1]){
                v[y][x+1] = true;
                num++;
                dfs(x+1,y);
            }
        }
        if(y-1>=0){
            if(d[y-1][x] != 1 && !v[y-1][x]){
                v[y-1][x] = true;
                num++;
                dfs(x,y-1);
            }
        }
        if(y+1<M){
            if(d[y+1][x] != 1 && !v[y+1][x]){
                v[y+1][x] = true;
                num++;
                dfs(x,y+1);
            }
        }
    }



}
