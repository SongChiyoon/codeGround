import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 23..
 * 문제 : https://www.acmicpc.net/problem/11399
 */
public class ATM {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];

        for(int i=0;i<N;i++){
            p[i] = sc.nextInt();
        }
        Arrays.sort(p);

        int Answer = 0;
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<=i;j++){
                sum += p[j];
            }
            Answer += sum;
        }
        System.out.println(Answer);

    }
}
