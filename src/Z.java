import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 29..
 * 문제 : https://www.acmicpc.net/problem/1074
 */
public class Z {

    static int[][] d;
    static int ans = 0;
    static int ansX, ansY;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        N = (int)Math.pow(2, N);
        ansY = sc.nextInt();
        ansX = sc.nextInt();
        find(0,0, N);
    }

    public static void find(int x, int y, int N){
        if(N <= 2){
            for(int i=y; i<y+N;i++){
                for(int j=x;j<x+N;j++){
                    if(i==ansY && j==ansX){
                        println(ans);
                        return;
                    }
                    ans++;
                }
            }
            return;
        }
        int m = N/2;
        find(x,y,m);
        find(x+m,y,m);
        find(x,y+m,m);
        find(x+m,y+m,m);
    }
    static void println(Object o){
        System.out.println(o);
    }
    static void println(){
        System.out.println();
    }
    static void print(Object o){
        System.out.print(o);
    }
}
