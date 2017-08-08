import java.util.*;

/**
 * Created by songchiyun on 2017. 8. 8..
 * 문제 : https://www.acmicpc.net/problem/2667
 */
public class apartment {
    static int[][] d;
    static boolean[][] v;
    static class coord{
        int x, y;
        coord(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        d = new int[N][N];
        v = new boolean[N][N];
        for(int i=0;i<N;i++){
            String input = sc.next();
            for(int j=0;j<N;j++) {
                d[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }
        int num = 1;
        List<Integer> numberList = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if(!v[i][j] && d[i][j] == 1){
                    numberList.add(dfs(new coord(j, i), N, num));
                    num++;
                }
            }
        }

        System.out.println(num-1);
        Collections.sort(numberList);
        for(int number : numberList){
            System.out.println(number);
        }

    }

    public static int dfs(coord c, int N, int name){
        Stack<coord> s = new Stack<>();
        d[c.y][c.x] = name;
        s.add(c);
        v[c.y][c.x] = true;
        int number = 0;
        while( !s.isEmpty() ){
            coord a = s.pop();
            number++;
            int x = a.x;
            int y= a.y;
            if(a.x-1>=0){
                if(!v[y][x-1] && d[y][x-1] == 1){
                    v[y][x-1] = true;
                    d[y][x-1] = name;
                    s.add(new coord(x-1,y));
                }
            }
            if(a.y-1>=0){
                if(!v[y-1][x] && d[y-1][x] == 1){
                    v[y-1][x] = true;
                    d[y-1][x] = name;
                    s.add(new coord(x,y-1));
                }
            }
            if(a.x+1<N){
                if(!v[y][x+1] && d[y][x+1] == 1){
                    v[y][x+1] = true;
                    d[y][x+1] = name;
                    s.add(new coord(x+1,y));
                }
            }
            if(a.y+1<N){
                if(!v[y+1][x] && d[y+1][x] == 1){
                    v[y+1][x] = true;
                    d[y+1][x] = name;
                    s.add(new coord(x,y+1));
                }
            }
        }
        return number;
    }
}
