/**
 * Created by songchiyun on 2017. 11. 22..
 * problem : https://www.acmicpc.net/problem/11651
 */
import java.util.*;
public class PointArrange2 {

    static class coord implements Comparable<coord>{
        int x, y;
        coord(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(coord other) {
            if(this.y == other.y){
                return Integer.compare(this.x, other.x);
            }
            else{
                return Integer.compare(this.y, other.y);
            }
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        coord[] ps = new coord[N];
        for(int i=0;i<N;i++){
            int tx = sc.nextInt();
            int ty = sc.nextInt();
            ps[i] = new coord(tx, ty);
        }
        Arrays.sort(ps);
        StringBuilder results = new StringBuilder();
        for(int i=0;i<N;i++){
            results.append(ps[i].x +" "+ps[i].y +"\n");
        }
        System.out.println(results);

    }
}
