import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 4..
 * 문제 : https://www.acmicpc.net/problem/9466
 *
 */
public class TeamProject {

    static int[] d;
    static boolean[] v;
    static int N;
    static boolean find;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0;t<T;t++){

            N = sc.nextInt();
            d = new int[N+1];
            for(int i=1;i<=N;i++)
                d[i] = sc.nextInt();
            v= new boolean[N+1];

            for(int i=1;i<=N;i++){
                if(!v[i]){
                    find = false;
                    v[i] = true;
                    dfs(i,i);
                    if(!find)
                        v[i] = false;

                }

            }
            int ans = 0;
            for(int i=1;i<=N;i++){
                if(!v[i])
                    ans++;
            }
            System.out.println(ans);

        }
    }
    static void dfs(int source, int current){

        if(source == d[current]){
            find = true;
            return;
        }
        if(!v[d[current]]) {
            v[d[current]] = true;
            dfs(source, d[current]);
            if (!find)
                v[d[current]] = false;
        }

    }
}

