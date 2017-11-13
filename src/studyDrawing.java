/**
 * Created by songchiyun on 2017. 11. 13..
 * problem : https://www.acmicpc.net/problem/9521
 */
import java.util.*;
public class studyDrawing {

    static int N,K;
    static int[] f;
    static int[] mf;

    static int[] d;
    static int ans = 1;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        d = new int[N];
        for(int i=0;i<N;i++)
            d[i] =-1;
        f = new int[N];
        mf = new int[N];
        for(int i=0;i<N;i++) {
            f[i] = sc.nextInt()-1;
            mf[f[i]] = i;
        }

        ans = K;
        go(1);
        System.out.println(ans);

    }
    static void go(int position){

        if(position == N) {
            return;
        }

        if(position == f[position]){

            ans *= K;
            ans %= 1000000007;
            go(position+1);

        }
        else if(position < f[position]){

            ans *= K;
            ans %= 1000000007;
            go(position+1);

        }
        else{

            ans *= K-1;
            ans %= 1000000007;
            go(position+1);


        }


    }
}
