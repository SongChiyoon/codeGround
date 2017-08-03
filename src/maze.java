import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 3..
 * 문제 : https://www.acmicpc.net/problem/2178
 */
class coord{
    int y, x;
    coord(int y, int x){
        this.y = y;
        this.x=x;
    }
}
public class maze {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] d = new int[N+1][M+1];
        boolean[][] v = new boolean[N+1][M+1];
        for(int i =1;i<N+1;i++){
            String input = sc.next();
            for(int j=1;j<M+1;j++){
                d[i][j] = Integer.parseInt(String.valueOf(input.charAt(j-1)));
            }
        }
        coord source = new coord(1,1);
        v[1][1] = true;
        Queue<coord> q = new LinkedList<>();
        q.add(source);
        while( !q.isEmpty() ){
            coord active = q.remove();
            int x = active.x;
            int y = active.y;
            if(x == M && y == N){
                continue;
            }
            if(y-1>0){
                if(d[y-1][x] != 0){
                    if(!v[y-1][x]){
                        v[y-1][x] = true;
                        d[y-1][x] = d[y][x] +1;
                        q.add(new coord(y-1,x));
                    }
                    else{
                        if(d[y-1][x] > d[y][x]+1) {
                            d[y - 1][x] = d[y][x] + 1;
                            q.add(new coord(y - 1, x));
                        }

                    }

                }
            }
            if(y+1<=N){
                if(d[y+1][x] != 0){
                    if(!v[y+1][x]){
                        v[y+1][x] = true;
                        d[y+1][x] = d[y][x] +1;
                        q.add(new coord(y+1,x));
                    }
                    else{
                        if(d[y+1][x] > d[y][x]+1) {
                            d[y + 1][x] = d[y][x] + 1;
                            q.add(new coord(y+1,x));
                        }

                    }

                }
            }
            if(x-1>0){
                if(d[y][x-1] != 0){
                    if(!v[y][x-1]){
                        v[y][x-1] = true;
                        d[y][x-1] = d[y][x] +1;
                        q.add(new coord(y,x-1));
                    }
                    else{
                        if(d[y][x-1] > d[y][x]+1) {
                            d[y][x - 1] = d[y][x] + 1;
                            q.add(new coord(y,x-1));
                        }

                    }

                }
            }
            if(x+1<=M){
                if(d[y][x+1] != 0){
                    if(!v[y][x+1]){
                        v[y][x+1] = true;
                        d[y][x+1] = d[y][x] +1;
                        q.add(new coord(y,x+1));

                    }
                    else{
                        if(d[y][x+1] > d[y][x]+1) {
                            d[y][x + 1] = d[y][x] + 1;
                            q.add(new coord(y,x+1));
                        }
                    }
                }
            }

        }
        System.out.println(d[N][M]);

    }

}
