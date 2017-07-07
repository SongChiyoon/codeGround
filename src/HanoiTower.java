import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 7..
 */
public class HanoiTower {
    static int Answer;
    public static void main(String[] args) throws Exception	{
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();
            Answer = 0;
            System.out.println("Case #"+(test_case+1));

            hanoi(N,1,2,3);

        }
    }
    public static void move(int from, int to){
        System.out.println(from +"->" + to);
    }

    public static void hanoi(int n, int from, int by, int to){
        if (n == 1)
            move(from, to);
        else{
            hanoi(n - 1, from, to, by);    // 1번  N-1개의 원반을 기둥3을 거쳐 2로 옮긴다.
            move(from, to);                // 2번 기둥 1에서 1개의 원반을 기둥 3으롱 롬긴다.
            hanoi(n - 1, by, from, to);    // 3번 기둥 2에서 N-1개의 원반을 기둥 3으로 옮긴다.
        }
    }

}
