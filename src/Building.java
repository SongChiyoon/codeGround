import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 15..
 * 문제 : https://www.acmicpc.net/problem/6593
 */
public class Building {

    static class coord implements Comparable<coord>{
        int h, y, x;
        int cost;

        coord(int h, int y, int x, int cost){
            this.h = h;
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(coord other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    static char[][][] d;
    static int[][][] cost;
    static coord start, target;
    static int H,N,M;
    static int ans;
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        while(true){
            ans = Integer.MAX_VALUE;
            H = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            if(H==0 && N==0 && M ==0)
                break;

            d = new char[H][N][M];
            cost = new int[H][N][M];
            building(sc);
            //dfs(start, 0);
            dijkstra();
            ans = cost[target.h][target.y][target.x];

            if(ans == Integer.MAX_VALUE)
                System.out.println("Trapped!");
            else{
                System.out.println("Escaped in "+ans+" minute(s).");
            }
        }
    }
    static void dijkstra(){
        PriorityQueue<coord> pq = new PriorityQueue<>();
        cost[start.h][start.y][start.x] = 0;
        pq.add(start);

        while( !pq.isEmpty() ){

            coord active = pq.remove();
            int h = active.h;
            int y = active.y;
            int x = active.x;

            if(x-1>=0){
                if(d[h][y][x-1] != '#' && cost[h][y][x-1] > active.cost+1) {
                    cost[h][y][x-1] = active.cost+1;
                    pq.add(new coord(h, y, x-1,active.cost+1 ));
                }
            }
            if(x+1<M){
                if(d[h][y][x+1] != '#' && cost[h][y][x+1] > active.cost+1) {
                    cost[h][y][x+1] = active.cost+1;
                    pq.add(new coord(h, y, x+1, active.cost+1));
                }
            }
            if(y-1>=0) {
                if (d[h][y - 1][x] != '#' && cost[h][y-1][x] > active.cost+1) {
                    cost[h][y-1][x] = active.cost+1;
                    pq.add(new coord(h, y-1, x, active.cost+1));
                }
            }
            if(y+1<N){
                if(d[h][y+1][x] != '#' && cost[h][y+1][x] > active.cost+1) {
                    cost[h][y+1][x] = active.cost+1;
                    pq.add(new coord(h, y+1, x, active.cost+1));
                }
            }
            if(h-1>=0){
                if(d[h-1][y][x] != '#' && cost[h-1][y][x] > active.cost+1) {
                    cost[h-1][y][x] = active.cost+1;
                    pq.add(new coord(h-1, y, x, active.cost+1));
                }
            }
            if(h+1<H){
                if(d[h+1][y][x] != '#' && cost[h+1][y][x] > active.cost+1) {
                    cost[h+1][y][x] = active.cost+1;;
                    pq.add(new coord(h+1, y, x, active.cost+1));
                }
            }


        }



    }
    /*
    static void dfs(coord c, int m){
        int h = c.h;
        int y = c.y;
        int x = c.x;
        v[h][y][x] = true;
        if(d[h][y][x] == 'E'){
            v[h][y][x] = false;
            ans = Math.min(ans, m);
            return;
        }
        if(ans < m)
        {
            v[h][y][x] = false;
            return;
        }
        if(x-1>=0){
            if(d[h][y][x-1] != '#' && !v[h][y][x-1]) {
                dfs(new coord(h, y, x - 1), m + 1);
            }
        }
        if(x+1<M){
            if(d[h][y][x+1] != '#' && !v[h][y][x+1]) {
                dfs(new coord(h, y, x + 1), m + 1);
            }
        }
        if(y-1>=0) {
            if (d[h][y - 1][x] != '#' && !v[h][y - 1][x]) {
                dfs(new coord(h,y-1,x), m+1);
            }
        }
        if(y+1<N){
            if(d[h][y+1][x] != '#' && !v[h][y+1][x]){
                dfs(new coord(h,y+1,x),m+1);
            }
        }
        if(h-1>=0){
            if(d[h-1][y][x] != '#' && !v[h-1][y][x]){
                dfs(new coord(h-1,y,x),m+1);
            }
        }
        if(h+1<H){
            if(d[h+1][y][x] != '#' && !v[h+1][y][x]){
                dfs(new coord(h+1,y,x),m+1);
            }
        }
        v[h][y][x] = false;

    }*/
    static void building(Scanner sc){

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                String input = sc.next();
                for(int l=0;l<M;l++){
                    if(input.charAt(l) == 'S')
                        start = new coord(i,j,l, 0);
                    if(input.charAt(l) == 'E')
                        target = new coord(i,j,l, Integer.MAX_VALUE);

                    d[i][j][l] = input.charAt(l);
                    cost[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }
    }
}
