/**
 * Created by songchiyun on 2017. 11. 13..
 * problem : https://www.acmicpc.net/problem/2146
 */
import java.util.*;
public class connectBridge {
    static class coord{
        int y, x;
        coord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int[][] d;
    static boolean[][] v;
    static char name = 'a';


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d = new int[N][N];
        v = new boolean[N][N];
        List<coord> list = new LinkedList<>();
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) {
                d[i][j] = sc.nextInt();
                if(d[i][j] != 0)
                    list.add(new coord(i,j));
            }
        int num = 2;
        int ans = Integer.MAX_VALUE;
        for(coord a : list){
            if(!v[a.y][a.x]){
                int len = connect(a, num)-1;
                ans = Math.min(len, ans);
                num++;
            }
        }
        System.out.println(ans);




    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int connect(coord current, int num){

        d[current.y][current.x] = num;
        v[current.y][current.x] = true;
        int[][] br = new int[N][N];
        br[current.y][current.x] = num;

        Queue<coord> q = new LinkedList<>();
        Queue<coord> get = new LinkedList<>();
        q.add(current);
        get.add(current);

        while(!q.isEmpty()){

            coord a = q.remove();

            for(int i=0;i<4;i++){

                int ty = a.y+dy[i];
                int tx = a.x+dx[i];

                if(ty>=0&&ty<N&&tx>=0&&tx<N){

                    if(d[ty][tx]!=0&&!v[ty][tx]){
                        v[ty][tx] = true;
                        d[ty][tx] = num;
                        br[ty][tx] = num;
                        coord add = new coord(ty,tx);
                        q.add(add);
                        get.add(add);
                    }

                }

            }


        }
        List<coord> storage = new LinkedList<>();
        int count = 0;
        while(true){
            count++;
            while(!get.isEmpty()){

                coord a = get.remove();
                for(int i=0;i<4;i++){

                    int ty = a.y+dy[i];
                    int tx = a.x+dx[i];
                    if(ty>=0&&ty<N&&tx>=0&&tx<N){

                        if(d[ty][tx]==0 && br[ty][tx]==0){
                            br[ty][tx] = num;
                            storage.add(new coord(ty,tx));
                        }
                        else if(d[ty][tx] !=0 && d[ty][tx] != num){
                            return count;
                        }

                    }
                }


            }
            for(coord add : storage)
                get.add(add);
            storage.clear();

        }

    }
    static void printf(int[][] t){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(d[i][j]==0)
                    System.out.print(t[i][j] +" ");
                else
                    System.out.print(1 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
