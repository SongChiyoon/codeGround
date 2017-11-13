/**
 * Created by songchiyun on 2017. 11. 13..
 * problem : https://www.acmicpc.net/problem/5566
 */
import java.util.*;
public class dice {

    static int[] road;
    static int position;
    static int N;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        road = new int[N];
        for(int i=0;i<N;i++)
            road[i] = sc.nextInt();
        position = 0;
        for(int i=0;i<M;i++)
        {
            int d = sc.nextInt();
            game(d, true);
            if(position == N-1){
                System.out.println(i+1);
                break;
            }
        }

    }
    static void game(int d, boolean first){
        if(position+d <= 0)
            position = 0;
        else if(position+d >=N-1)
            position = N-1;
        else{
            if(road[position+d]==0){
                position += d;
                return;
            }
            else{
                position += d;
                if(first)
                    game(road[position], false);
                else
                    return;
            }
        }
    }
}
