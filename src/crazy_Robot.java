import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 18..
 * problem : https://www.acmicpc.net/problem/1405
 */
public class crazy_Robot {

    static class coord{
        int y, x;
        coord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static boolean[][] v;
    static int[] p;
    static int N;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        p = new int[4];
        for(int i=0;i<p.length;i++)   // 0 : 동 / 1 : 서 / 2 : 남 / 3 : 북
            p[i] = sc.nextInt();

        int[][] d = new int[100][100];
        v = new boolean[100][100];

        coord start = new coord(14,14);
        int x, y;
        x = start.x;
        y = start.y;
        v[14][14] = true;

        dfs(1, new coord(y,x-1), (double)p[1]/100 );
        dfs(1, new coord(y,x+1), (double)p[0]/100 );
        dfs(1, new coord(y-1,x), (double)p[3]/100 );
        dfs(1, new coord(y+1,x), (double)p[2]/100 );

        System.out.println(ans);
    }
    static double ans;
    static void dfs(int step, coord current, double weight){
        if(step == N){
            ans += weight;
            return;
        }
        int x = current.x;
        int y = current.y;
        v[y][x] = true;

        if(!v[y][x-1]){
            dfs(step+1, new coord(y, x-1), weight * p[1]/100);
        }
        if(!v[y][x+1]){
            dfs(step+1, new coord(y, x+1), weight * p[0]/100);
        }
        if(!v[y-1][x]){
            dfs(step+1, new coord(y-1, x), weight * p[3]/100);
        }
        if(!v[y+1][x]){
            dfs(step+1, new coord(y+1, x), weight * p[2]/100);
        }
        v[y][x] = false;

    }


}
